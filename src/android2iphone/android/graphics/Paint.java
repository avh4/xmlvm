/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.graphics;

/*
 import android.text.TextUtils;
 import android.text.SpannableString;
 import android.text.SpannedString;
 import android.text.GraphicsOperations;
 */
import org.xmlvm.iphone.CGContext;
import org.xmlvm.iphone.NSString;
import org.xmlvm.iphone.UIFont;

import android.internal.Assert;
import android.util.Log;

/**
 * The Paint class holds the style and color information about how to draw
 * geometries, text and bitmaps.
 */
public class Paint {

    // private ColorFilter mColorFilter;
    // private MaskFilter mMaskFilter;
    // private PathEffect mPathEffect;
    // private Rasterizer mRasterizer;
    // private Shader mShader;
    private Typeface         mTypeface;
    // private Xfermode mXfermode;

    private boolean          mHasCompatScaling;
    private float            mCompatScaling;
    private float            mInvCompatScaling;

    private int              mFlags;
    private Style            mStyle;
    private Cap              mCap;
    private Join             mJoin;
    private Align            mAlign;
    private int              mColor;
    private float            mTextSize;

    // Shadow layer
    private float            mShadowRadius;
    private float            mShadowDX;
    private float            mShadowDY;
    private float[]          mShadowColor;

    /** bit mask for the flag enabling antialiasing */
    public static final int  ANTI_ALIAS_FLAG       = 0x01;
    /** bit mask for the flag enabling bitmap filtering */
    public static final int  FILTER_BITMAP_FLAG    = 0x02;
    /** bit mask for the flag enabling dithering */
    public static final int  DITHER_FLAG           = 0x04;
    /** bit mask for the flag enabling underline text */
    public static final int  UNDERLINE_TEXT_FLAG   = 0x08;
    /** bit mask for the flag enabling strike-thru text */
    public static final int  STRIKE_THRU_TEXT_FLAG = 0x10;
    /** bit mask for the flag enabling fake-bold text */
    public static final int  FAKE_BOLD_TEXT_FLAG   = 0x20;
    /** bit mask for the flag enabling linear-text (no caching) */
    public static final int  LINEAR_TEXT_FLAG      = 0x40;
    /** bit mask for the flag enabling subpixel-text */
    public static final int  SUBPIXEL_TEXT_FLAG    = 0x80;
    /** bit mask for the flag enabling device kerning for text */
    public static final int  DEV_KERN_TEXT_FLAG    = 0x100;

    // we use this when we first create a paint
    private static final int DEFAULT_PAINT_FLAGS   = DEV_KERN_TEXT_FLAG;


    /**
     * The Style specifies if the primitive being drawn is filled, stroked, or
     * both (in the same color). The default is FILL.
     */
    public enum Style {
        /**
         * Geometry and text drawn with this style will be filled, ignoring all
         * stroke-related settings in the paint.
         */
        FILL(0),
        /**
         * Geometry and text drawn with this style will be stroked, respecting
         * the stroke-related fields on the paint.
         */
        STROKE(1),
        /**
         * Geometry and text drawn with this style will be both filled and
         * stroked at the same time, respecting the stroke-related fields on the
         * paint.
         */
        FILL_AND_STROKE(2);

        Style(int nativeInt) {
            this.nativeInt = nativeInt;
        }


        final int nativeInt;
    }


    /**
     * The Cap specifies the treatment for the beginning and ending of stroked
     * lines and paths. The default is BUTT.
     */
    public enum Cap {
        /**
         * The stroke ends with the path, and does not project beyond it.
         */
        BUTT(0),
        /**
         * The stroke projects out as a semicircle, with the center at the end
         * of the path.
         */
        ROUND(1),
        /**
         * The stroke projects out as a square, with the center at the end of
         * the path.
         */
        SQUARE(2);

        private Cap(int nativeInt) {
            this.nativeInt = nativeInt;
        }


        final int nativeInt;
    }


    /**
     * The Join specifies the treatment where lines and curve segments join on a
     * stroked path. The default is MITER.
     */
    public enum Join {
        /**
         * The outer edges of a join meet at a sharp angle
         */
        MITER(0),
        /**
         * The outer edges of a join meet in a circular arc.
         */
        ROUND(1),
        /**
         * The outer edges of a join meet with a straight line
         */
        BEVEL(2);

        private Join(int nativeInt) {
            this.nativeInt = nativeInt;
        }


        final int nativeInt;
    }


    /**
     * Align specifies how drawText aligns its text relative to the [x,y]
     * coordinates. The default is LEFT.
     */
    public enum Align {
        /**
         * The text is drawn to the right of the x,y origin
         */
        LEFT(0),
        /**
         * The text is drawn centered horizontally on the x,y origin
         */
        CENTER(1),
        /**
         * The text is drawn to the left of the x,y origin
         */
        RIGHT(2);

        private Align(int nativeInt) {
            this.nativeInt = nativeInt;
        }


        final int nativeInt;
    }


    /**
     * Create a new paint with default settings.
     */
    public Paint() {
        this(0);
    }

    /**
     * Create a new paint with the specified flags. Use setFlags() to change
     * these after the paint is created.
     * 
     * @param flags
     *            initial flag bits, as if they were passed via setFlags().
     */
    public Paint(int flags) {
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
    }

    /**
     * Create a new paint, initialized with the attributes in the specified
     * paint parameter.
     * 
     * @param paint
     *            Existing paint used to initialized the attributes of the new
     *            paint.
     */
    public Paint(Paint paint) {
        mHasCompatScaling = paint.mHasCompatScaling;
        mCompatScaling = paint.mCompatScaling;
        mInvCompatScaling = paint.mInvCompatScaling;
    }

    /** Restores the paint to its default settings. */
    public void reset() {
        setFlags(DEFAULT_PAINT_FLAGS);
        mHasCompatScaling = false;
        mCompatScaling = mInvCompatScaling = 1;
    }

    /**
     * Copy the fields from src into this paint. This is equivalent to calling
     * get() on all of the src fields, and calling the corresponding set()
     * methods on this.
     */
    public void set(Paint src) {
        Log.w("xmlvm", "android.graphics.Paint.set() is not copying all members");
        if (this != src) {
            // copy over our java settings
            // mColorFilter = src.mColorFilter;
            // mMaskFilter = src.mMaskFilter;
            // mPathEffect = src.mPathEffect;
            // mRasterizer = src.mRasterizer;
            // mShader = src.mShader;
            mTypeface = src.mTypeface;
            // mXfermode = src.mXfermode;
            mHasCompatScaling = src.mHasCompatScaling;
            mCompatScaling = src.mCompatScaling;
            mInvCompatScaling = src.mInvCompatScaling;
            mFlags = src.mFlags;
            mStyle = src.mStyle;
            mCap = src.mCap;
            mJoin = src.mJoin;
            mAlign = src.mAlign;
            mColor = src.mColor;
            mTextSize = src.mTextSize;
            this.mShadowRadius = src.mShadowRadius;
            this.mShadowDX = src.mShadowDX;
            this.mShadowDY = src.mShadowDY;
            this.mShadowColor = src.mShadowColor;
        }
    }

    /** @hide */
    public void setCompatibilityScaling(float factor) {
        if (factor == 1.0) {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } else {
            mHasCompatScaling = true;
            mCompatScaling = factor;
            mInvCompatScaling = 1.0f / factor;
        }
    }

    /**
     * Return the paint's flags. Use the Flag enum to test flag values.
     * 
     * @return the paint's flags (see enums ending in _Flag for bit masks)
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * Set the paint's flags. Use the Flag enum to specific flag values.
     * 
     * @param flags
     *            The new flag bits for the paint
     */
    public void setFlags(int flags) {
        mFlags = flags;
    }

    /**
     * Helper for getFlags(), returning true if ANTI_ALIAS_FLAG bit is set
     * AntiAliasing smooths out the edges of what is being drawn, but is has no
     * impact on the interior of the shape. See setDither() and
     * setFilterBitmap() to affect how colors are treated.
     * 
     * @return true if the antialias bit is set in the paint's flags.
     */
    public final boolean isAntiAlias() {
        return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit
     * AntiAliasing smooths out the edges of what is being drawn, but is has no
     * impact on the interior of the shape. See setDither() and
     * setFilterBitmap() to affect how colors are treated.
     * 
     * @param aa
     *            true to set the antialias bit in the flags, false to clear it
     */
    public void setAntiAlias(boolean aa) {
        if (aa) {
            mFlags |= ANTI_ALIAS_FLAG;
        } else {
            mFlags &= ~ANTI_ALIAS_FLAG;
        }
    }

    /**
     * Helper for getFlags(), returning true if DITHER_FLAG bit is set Dithering
     * affects how colors that are higher precision than the device are
     * down-sampled. No dithering is generally faster, but higher precision
     * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
     * distribute the error inherent in this process, to reduce the visual
     * artifacts.
     * 
     * @return true if the dithering bit is set in the paint's flags.
     */
    public final boolean isDither() {
        return (getFlags() & DITHER_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the DITHER_FLAG bit Dithering
     * affects how colors that are higher precision than the device are
     * down-sampled. No dithering is generally faster, but higher precision
     * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
     * distribute the error inherent in this process, to reduce the visual
     * artifacts.
     * 
     * @param dither
     *            true to set the dithering bit in flags, false to clear it
     */
    public void setDither(boolean dither) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper for getFlags(), returning true if LINEAR_TEXT_FLAG bit is set
     * 
     * @return true if the lineartext bit is set in the paint's flags
     */
    public final boolean isLinearText() {
        return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the LINEAR_TEXT_FLAG bit
     * 
     * @param linearText
     *            true to set the linearText bit in the paint's flags, false to
     *            clear it.
     */
    public void setLinearText(boolean linearText) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper for getFlags(), returning true if SUBPIXEL_TEXT_FLAG bit is set
     * 
     * @return true if the subpixel bit is set in the paint's flags
     */
    public final boolean isSubpixelText() {
        return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the SUBPIXEL_TEXT_FLAG bit
     * 
     * @param subpixelText
     *            true to set the subpixelText bit in the paint's flags, false
     *            to clear it.
     */
    public void setSubpixelText(boolean subpixelText) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper for getFlags(), returning true if UNDERLINE_TEXT_FLAG bit is set
     * 
     * @return true if the underlineText bit is set in the paint's flags.
     */
    public final boolean isUnderlineText() {
        return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the UNDERLINE_TEXT_FLAG bit
     * 
     * @param underlineText
     *            true to set the underlineText bit in the paint's flags, false
     *            to clear it.
     */
    public void setUnderlineText(boolean underlineText) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper for getFlags(), returning true if STRIKE_THRU_TEXT_FLAG bit is set
     * 
     * @return true if the strikeThruText bit is set in the paint's flags.
     */
    public final boolean isStrikeThruText() {
        return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit
     * 
     * @param strikeThruText
     *            true to set the strikeThruText bit in the paint's flags, false
     *            to clear it.
     */
    public void setStrikeThruText(boolean strikeThruText) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper for getFlags(), returning true if FAKE_BOLD_TEXT_FLAG bit is set
     * 
     * @return true if the fakeBoldText bit is set in the paint's flags.
     */
    public final boolean isFakeBoldText() {
        return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit
     * 
     * @param fakeBoldText
     *            true to set the fakeBoldText bit in the paint's flags, false
     *            to clear it.
     */
    public void setFakeBoldText(boolean fakeBoldText) {
        if (fakeBoldText) {
            mFlags |= FAKE_BOLD_TEXT_FLAG;
        } else {
            mFlags &= ~FAKE_BOLD_TEXT_FLAG;
        }
    }

    /**
     * Whether or not the bitmap filter is activated. Filtering affects the
     * sampling of bitmaps when they are transformed. Filtering does not affect
     * how the colors in the bitmap are converted into device pixels. That is
     * dependent on dithering and xfermodes.
     * 
     * @see #setFilterBitmap(boolean) setFilterBitmap()
     */
    public final boolean isFilterBitmap() {
        return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }

    /**
     * Helper for setFlags(), setting or clearing the FILTER_BITMAP_FLAG bit.
     * Filtering affects the sampling of bitmaps when they are transformed.
     * Filtering does not affect how the colors in the bitmap are converted into
     * device pixels. That is dependent on dithering and xfermodes.
     * 
     * @param filter
     *            true to set the FILTER_BITMAP_FLAG bit in the paint's flags,
     *            false to clear it.
     */
    public void setFilterBitmap(boolean filter) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Return the paint's style, used for controlling how primitives' geometries
     * are interpreted (except for drawBitmap, which always assumes FILL_STYLE).
     * 
     * @return the paint's style setting (Fill, Stroke, StrokeAndFill)
     */
    public Style getStyle() {
        return mStyle;
    }

    /**
     * Set the paint's style, used for controlling how primitives' geometries
     * are interpreted (except for drawBitmap, which always assumes Fill).
     * 
     * @param style
     *            The new style to set in the paint
     */
    public void setStyle(Style style) {
        mStyle = style;
    }

    /**
     * Return the paint's color. Note that the color is a 32bit value containing
     * alpha as well as r,g,b. This 32bit value is not premultiplied, meaning
     * that its alpha can be any value, regardless of the values of r,g,b. See
     * the Color class for more details.
     * 
     * @return the paint's color (and alpha).
     */
    public int getColor() {
        return mColor;
    }

    /**
     * Set the paint's color. Note that the color is an int containing alpha as
     * well as r,g,b. This 32bit value is not premultiplied, meaning that its
     * alpha can be any value, regardless of the values of r,g,b. See the Color
     * class for more details.
     * 
     * @param color
     *            The new color (including alpha) to set in the paint.
     */
    public void setColor(int color) {
        mColor = color;
    }

    /**
     * Helper to getColor() that just returns the color's alpha value. This is
     * the same as calling getColor() >>> 24. It always returns a value between
     * 0 (completely transparent) and 255 (completely opaque).
     * 
     * @return the alpha component of the paint's color.
     */
    public int getAlpha() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Helper to setColor(), that only assigns the color's alpha value, leaving
     * its r,g,b values unchanged. Results are undefined if the alpha value is
     * outside of the range [0..255]
     * 
     * @param a
     *            set the alpha component [0..255] of the paint's color.
     */
    public void setAlpha(int a) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Helper to setColor(), that takes a,r,g,b and constructs the color int
     * 
     * @param a
     *            The new alpha component (0..255) of the paint's color.
     * @param r
     *            The new red component (0..255) of the paint's color.
     * @param g
     *            The new green component (0..255) of the paint's color.
     * @param b
     *            The new blue component (0..255) of the paint's color.
     */
    public void setARGB(int a, int r, int g, int b) {
        setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    /**
     * Return the width for stroking.
     * <p />
     * A value of 0 strokes in hairline mode. Hairlines always draws a single
     * pixel independent of the canva's matrix.
     * 
     * @return the paint's stroke width, used whenever the paint's style is
     *         Stroke or StrokeAndFill.
     */
    public float getStrokeWidth() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Set the width for stroking. Pass 0 to stroke in hairline mode. Hairlines
     * always draws a single pixel independent of the canva's matrix.
     * 
     * @param width
     *            set the paint's stroke width, used whenever the paint's style
     *            is Stroke or StrokeAndFill.
     */
    public void setStrokeWidth(float width) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Return the paint's stroke miter value. Used to control the behavior of
     * miter joins when the joins angle is sharp.
     * 
     * @return the paint's miter limit, used whenever the paint's style is
     *         Stroke or StrokeAndFill.
     */
    public float getStrokeMiter() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Set the paint's stroke miter value. This is used to control the behavior
     * of miter joins when the joins angle is sharp. This value must be >= 0.
     * 
     * @param miter
     *            set the miter limit on the paint, used whenever the paint's
     *            style is Stroke or StrokeAndFill.
     */
    public void setStrokeMiter(float miter) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Return the paint's Cap, controlling how the start and end of stroked
     * lines and paths are treated.
     * 
     * @return the line cap style for the paint, used whenever the paint's style
     *         is Stroke or StrokeAndFill.
     */
    public Cap getStrokeCap() {
        return mCap;
    }

    /**
     * Set the paint's Cap.
     * 
     * @param cap
     *            set the paint's line cap style, used whenever the paint's
     *            style is Stroke or StrokeAndFill.
     */
    public void setStrokeCap(Cap cap) {
        mCap = cap;
    }

    /**
     * Return the paint's stroke join type.
     * 
     * @return the paint's Join.
     */
    public Join getStrokeJoin() {
        return mJoin;
    }

    /**
     * Set the paint's Join.
     * 
     * @param join
     *            set the paint's Join, used whenever the paint's style is
     *            Stroke or StrokeAndFill.
     */
    public void setStrokeJoin(Join join) {
        mJoin = join;
    }

    /**
     * Applies any/all effects (patheffect, stroking) to src, returning the
     * result in dst. The result is that drawing src with this paint will be the
     * same as drawing dst with a default paint (at least from the geometric
     * perspective).
     * 
     * @param src
     *            input path
     * @param dst
     *            output path (may be the same as src)
     * @return true if the path should be filled, or false if it should be drawn
     *         with a hairline (width == 0)
     */
    // public boolean getFillPath(Path src, Path dst) {
    // return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    // }

    /**
     * Get the paint's shader object.
     * 
     * @return the paint's shader (or null)
     */
    // public Shader getShader() {
    // return mShader;
    // }

    /**
     * Set or clear the shader object.
     * <p />
     * Pass null to clear any previous shader. As a convenience, the parameter
     * passed is also returned.
     * 
     * @param shader
     *            May be null. the new shader to be installed in the paint
     * @return shader
     */
    // public Shader setShader(Shader shader) {
    // int shaderNative = 0;
    // if (shader != null)
    // shaderNative = shader.native_instance;
    // native_setShader(mNativePaint, shaderNative);
    // mShader = shader;
    // return shader;
    // }

    /**
     * Get the paint's colorfilter (maybe be null).
     * 
     * @return the paint's colorfilter (maybe be null)
     */

    // public ColorFilter getColorFilter() {
    // return mColorFilter;
    // }

    /**
     * Set or clear the paint's colorfilter, returning the parameter.
     * 
     * @param filter
     *            May be null. The new filter to be installed in the paint
     * @return filter
     */
    // public ColorFilter setColorFilter(ColorFilter filter) {
    // int filterNative = 0;
    // if (filter != null)
    // filterNative = filter.native_instance;
    // native_setColorFilter(mNativePaint, filterNative);
    // mColorFilter = filter;
    // return filter;
    // }

    /**
     * Get the paint's xfermode object.
     * 
     * @return the paint's xfermode (or null)
     */
    // public Xfermode getXfermode() {
    // return mXfermode;
    // }

    /**
     * Set or clear the xfermode object.
     * <p />
     * Pass null to clear any previous xfermode. As a convenience, the parameter
     * passed is also returned.
     * 
     * @param xfermode
     *            May be null. The xfermode to be installed in the paint
     * @return xfermode
     */
    // public Xfermode setXfermode(Xfermode xfermode) {
    // int xfermodeNative = 0;
    // if (xfermode != null)
    // xfermodeNative = xfermode.native_instance;
    // native_setXfermode(mNativePaint, xfermodeNative);
    // mXfermode = xfermode;
    // return xfermode;
    // }

    /**
     * Get the paint's patheffect object.
     * 
     * @return the paint's patheffect (or null)
     */
    // public PathEffect getPathEffect() {
    // return mPathEffect;
    // }

    /**
     * Set or clear the patheffect object.
     * <p />
     * Pass null to clear any previous patheffect. As a convenience, the
     * parameter passed is also returned.
     * 
     * @param effect
     *            May be null. The patheffect to be installed in the paint
     * @return effect
     */
    // public PathEffect setPathEffect(PathEffect effect) {
    // int effectNative = 0;
    // if (effect != null) {
    // effectNative = effect.native_instance;
    // }
    // native_setPathEffect(mNativePaint, effectNative);
    // mPathEffect = effect;
    // return effect;
    // }

    /**
     * Get the paint's maskfilter object.
     * 
     * @return the paint's maskfilter (or null)
     */
    // public MaskFilter getMaskFilter() {
    // return mMaskFilter;
    // }

    /**
     * Set or clear the maskfilter object.
     * <p />
     * Pass null to clear any previous maskfilter. As a convenience, the
     * parameter passed is also returned.
     * 
     * @param maskfilter
     *            May be null. The maskfilter to be installed in the paint
     * @return maskfilter
     */
    // public MaskFilter setMaskFilter(MaskFilter maskfilter) {
    // int maskfilterNative = 0;
    // if (maskfilter != null) {
    // maskfilterNative = maskfilter.native_instance;
    // }
    // native_setMaskFilter(mNativePaint, maskfilterNative);
    // mMaskFilter = maskfilter;
    // return maskfilter;
    // }

    /**
     * Get the paint's typeface object.
     * <p />
     * The typeface object identifies which font to use when drawing or
     * measuring text.
     * 
     * @return the paint's typeface (or null)
     */
    public Typeface getTypeface() {
        return mTypeface;
    }

    /**
     * Set or clear the typeface object.
     * <p />
     * Pass null to clear any previous typeface. As a convenience, the parameter
     * passed is also returned.
     * 
     * @param typeface
     *            May be null. The typeface to be installed in the paint
     * @return typeface
     */
    public Typeface setTypeface(Typeface typeface) {
        Log.w("xmlvm", "android.graphics.setTypeface() not calling native_setTypeFace()");
        // native_setTypeface(mNativePaint, typefaceNative);
        mTypeface = typeface;
        return typeface;
    }

    /**
     * Get the paint's rasterizer (or null).
     * <p />
     * The raster controls/modifies how paths/text are turned into alpha masks.
     * 
     * @return the paint's rasterizer (or null)
     */
    // public Rasterizer getRasterizer() {
    // return mRasterizer;
    // }

    /**
     * Set or clear the rasterizer object.
     * <p />
     * Pass null to clear any previous rasterizer. As a convenience, the
     * parameter passed is also returned.
     * 
     * @param rasterizer
     *            May be null. The new rasterizer to be installed in the paint.
     * @return rasterizer
     */
    // public Rasterizer setRasterizer(Rasterizer rasterizer) {
    // int rasterizerNative = 0;
    // if (rasterizer != null) {
    // rasterizerNative = rasterizer.native_instance;
    // }
    // native_setRasterizer(mNativePaint, rasterizerNative);
    // mRasterizer = rasterizer;
    // return rasterizer;
    // }

    /**
     * Temporary API to expose layer drawing. This draws a shadow layer below
     * the main layer, with the specified offset and color, and blur radius. If
     * radius is 0, then the shadow layer is removed.
     */
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        mShadowRadius = radius;
        mShadowDX = dx;
        mShadowDY = dy;
        int a = (color >> 24) & 0xff;
        int r = (color >> 16) & 0xff;
        int g = (color >> 8) & 0xff;
        int b = color & 0xff;
        mShadowColor = new float[] { r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f };
    }

    /**
     * Temporary API to clear the shadow layer.
     */
    public void clearShadowLayer() {
        setShadowLayer(0, 0, 0, 0);
    }

    /**
     * Return the paint's Align value for drawing text. This controls how the
     * text is positioned relative to its origin. LEFT align means that all of
     * the text will be drawn to the right of its origin (i.e. the origin
     * specifieds the LEFT edge of the text) and so on.
     * 
     * @return the paint's Align value for drawing text.
     */
    public Align getTextAlign() {
        return mAlign;
    }

    /**
     * Set the paint's text alignment. This controls how the text is positioned
     * relative to its origin. LEFT align means that all of the text will be
     * drawn to the right of its origin (i.e. the origin specifieds the LEFT
     * edge of the text) and so on.
     * 
     * @param align
     *            set the paint's Align value for drawing text.
     */
    public void setTextAlign(Align align) {
        mAlign = align;
    }

    /**
     * Return the paint's text size.
     * 
     * @return the paint's text size.
     */
    public float getTextSize() {
        return mTextSize;
    }

    /**
     * Set the paint's text size. This value must be > 0
     * 
     * @param textSize
     *            set the paint's text size.
     */
    public void setTextSize(float textSize) {
        mTextSize = textSize;
    }

    /**
     * Return the paint's horizontal scale factor for text. The default value is
     * 1.0.
     * 
     * @return the paint's scale factor in X for drawing/measuring text
     */
    public float getTextScaleX() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Set the paint's horizontal scale factor for text. The default value is
     * 1.0. Values > 1.0 will stretch the text wider. Values < 1.0 will stretch
     * the text narrower.
     * 
     * @param scaleX
     *            set the paint's scale in X for drawing/measuring text.
     */
    public void setTextScaleX(float scaleX) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Return the paint's horizontal skew factor for text. The default value is
     * 0.
     * 
     * @return the paint's skew factor in X for drawing text.
     */
    public float getTextSkewX() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Set the paint's horizontal skew factor for text. The default value is 0.
     * For approximating oblique text, use values around -0.25.
     * 
     * @param skewX
     *            set the paint's skew factor in X for drawing text.
     */
    public void setTextSkewX(float skewX) {
        Assert.NOT_IMPLEMENTED();
    }

    /**
     * Return the distance above (negative) the baseline (ascent) based on the
     * current typeface and text size.
     * 
     * @return the distance above (negative) the baseline (ascent) based on the
     *         current typeface and text size.
     */
    public float ascent() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Return the distance below (positive) the baseline (descent) based on the
     * current typeface and text size.
     * 
     * @return the distance below (positive) the baseline (descent) based on the
     *         current typeface and text size.
     */
    public float descent() {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }


    /**
     * Class that describes the various metrics for a font at a given text size.
     * Remember, Y values increase going down, so those values will be positive,
     * and values that measure distances going up will be negative. This class
     * is returned by getFontMetrics().
     */
    public static class FontMetrics {
        /**
         * The maximum distance above the baseline for the tallest glyph in the
         * font at a given text size.
         */
        public float top;
        /**
         * The recommended distance above the baseline for singled spaced text.
         */
        public float ascent;
        /**
         * The recommended distance below the baseline for singled spaced text.
         */
        public float descent;
        /**
         * The maximum distance below the baseline for the lowest glyph in the
         * font at a given text size.
         */
        public float bottom;
        /**
         * The recommended additional space to add between lines of text.
         */
        public float leading;
    }


    /**
     * Return the font's recommended interline spacing, given the Paint's
     * settings for typeface, textSize, etc. If metrics is not null, return the
     * fontmetric values in it.
     * 
     * @param metrics
     *            If this object is not null, its fields are filled with the
     *            appropriate values given the paint's text attributes.
     * @return the font's recommended interline spacing.
     */
    public float getFontMetrics(FontMetrics metrics) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Allocates a new FontMetrics object, and then calls getFontMetrics(fm)
     * with it, returning the object.
     */
    public FontMetrics getFontMetrics() {
        FontMetrics fm = new FontMetrics();
        getFontMetrics(fm);
        return fm;
    }


    /**
     * Convenience method for callers that want to have FontMetrics values as
     * integers.
     */
    public static class FontMetricsInt {
        public int top;
        public int ascent;
        public int descent;
        public int bottom;
        public int leading;


        @Override
        public String toString() {
            return "FontMetricsInt: top=" + top + " ascent=" + ascent + " descent=" + descent
                    + " bottom=" + bottom + " leading=" + leading;
        }
    }


    /**
     * Return the font's interline spacing, given the Paint's settings for
     * typeface, textSize, etc. If metrics is not null, return the fontmetric
     * values in it. Note: all values have been converted to integers from
     * floats, in such a way has to make the answers useful for both spacing and
     * clipping. If you want more control over the rounding, call
     * getFontMetrics().
     * 
     * @return the font's interline spacing.
     */
    public int getFontMetricsInt(FontMetricsInt fmi) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fm = new FontMetricsInt();
        getFontMetricsInt(fm);
        return fm;
    }

    /**
     * Return the recommend line spacing based on the current typeface and text
     * size.
     * 
     * @return recommend line spacing based on the current typeface and text
     *         size.
     */
    public float getFontSpacing() {
        return getFontMetrics(null);
    }

    /**
     * Return the width of the text.
     * 
     * @param text
     *            The text to measure
     * @param index
     *            The index of the first character to start measuring
     * @param count
     *            THe number of characters to measure, beginning with start
     * @return The width of the text
     */
    public float measureText(char[] text, int index, int count) {
        if (!mHasCompatScaling)
            return native_measureText(text, index, count);
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        return w * mInvCompatScaling;
    }

    private float native_measureText(char[] text, int index, int count) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Return the width of the text.
     * 
     * @param text
     *            The text to measure
     * @param start
     *            The index of the first character to start measuring
     * @param end
     *            1 beyond the index of the last character to measure
     * @return The width of the text
     */
    public float measureText(String text, int start, int end) {
        if (!mHasCompatScaling)
            return native_measureText(text, start, end);
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float w = native_measureText(text, start, end);
        setTextSize(oldSize);
        return w * mInvCompatScaling;
    }

    private float native_measureText(String text, int start, int end) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Return the width of the text.
     * 
     * @param text
     *            The text to measure
     * @return The width of the text
     */
    public float measureText(String text) {
        if (!mHasCompatScaling)
            return native_measureText(text);
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        return w * mInvCompatScaling;
    }

    private float native_measureText(String text) {
        return NSString.sizeWithFont(text, this.xmlvmGetUIFont()).width;
    }

    /**
     * Return the width of the text.
     * 
     * @param text
     *            The text to measure
     * @param start
     *            The index of the first character to start measuring
     * @param end
     *            1 beyond the index of the last character to measure
     * @return The width of the text
     */
    // public float measureText(CharSequence text, int start, int end) {
    // if (text instanceof String) {
    // return measureText((String)text, start, end);
    // }
    // if (text instanceof SpannedString ||
    // text instanceof SpannableString) {
    // return measureText(text.toString(), start, end);
    // }
    // if (text instanceof GraphicsOperations) {
    // return ((GraphicsOperations)text).measureText(start, end, this);
    // }
    //
    // char[] buf = TemporaryBuffer.obtain(end - start);
    // TextUtils.getChars(text, start, end, buf, 0);
    // float result = measureText(buf, 0, end - start);
    // TemporaryBuffer.recycle(buf);
    // return result;
    // }

    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     * 
     * @param text
     *            The text to measure
     * @param index
     *            The offset into text to begin measuring at
     * @param count
     *            The number of maximum number of entries to measure. If count
     *            is negative, then the characters before index are measured in
     *            reverse order. This allows for measuring the end of string.
     * @param maxWidth
     *            The maximum width to accumulate.
     * @param measuredWidth
     *            Optional. If not null, returns the actual width measured.
     * @return The number of chars that were measured. Will always be <=
     *         abs(count).
     */
    public int breakText(char[] text, int index, int count, float maxWidth, float[] measuredWidth) {
        if (!mHasCompatScaling) {
            return native_breakText(text, index, count, maxWidth, measuredWidth);
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        int res = native_breakText(text, index, count, maxWidth * mCompatScaling, measuredWidth);
        setTextSize(oldSize);
        if (measuredWidth != null)
            measuredWidth[0] *= mInvCompatScaling;
        return res;
    }

    private int native_breakText(char[] text, int index, int count, float maxWidth,
            float[] measuredWidth) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     * 
     * @param text
     *            The text to measure
     * @param start
     *            The offset into text to begin measuring at
     * @param end
     *            The end of the text slice to measure.
     * @param measureForwards
     *            If true, measure forwards, starting at start. Otherwise,
     *            measure backwards, starting with end.
     * @param maxWidth
     *            The maximum width to accumulate.
     * @param measuredWidth
     *            Optional. If not null, returns the actual width measured.
     * @return The number of chars that were measured. Will always be <= abs(end
     *         - start).
     */
    // public int breakText(CharSequence text, int start, int end,
    // boolean measureForwards,
    // float maxWidth, float[] measuredWidth) {
    // if (start == 0 && text instanceof String && end == text.length()) {
    // return breakText((String) text, measureForwards, maxWidth,
    // measuredWidth);
    // }
    //
    // char[] buf = TemporaryBuffer.obtain(end - start);
    // int result;
    //
    // TextUtils.getChars(text, start, end, buf, 0);
    //
    // if (measureForwards) {
    // result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
    // } else {
    // result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
    // }
    //
    // TemporaryBuffer.recycle(buf);
    // return result;
    // }

    /**
     * Measure the text, stopping early if the measured width exceeds maxWidth.
     * Return the number of chars that were measured, and if measuredWidth is
     * not null, return in it the actual width measured.
     * 
     * @param text
     *            The text to measure
     * @param measureForwards
     *            If true, measure forwards, starting with the first character
     *            in the string. Otherwise, measure backwards, starting with the
     *            last character in the string.
     * @param maxWidth
     *            The maximum width to accumulate.
     * @param measuredWidth
     *            Optional. If not null, returns the actual width measured.
     * @return The number of chars that were measured. Will always be <=
     *         abs(count).
     */
    public int breakText(String text, boolean measureForwards, float maxWidth, float[] measuredWidth) {
        if (!mHasCompatScaling) {
            return native_breakText(text, measureForwards, maxWidth, measuredWidth);
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        int res = native_breakText(text, measureForwards, maxWidth * mCompatScaling, measuredWidth);
        setTextSize(oldSize);
        if (measuredWidth != null)
            measuredWidth[0] *= mInvCompatScaling;
        return res;
    }

    private int native_breakText(String text, boolean measureForwards, float maxWidth,
            float[] measuredWidth) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    /**
     * Return the advance widths for the characters in the string.
     * 
     * @param text
     *            The text to measure
     * @param index
     *            The index of the first char to to measure
     * @param count
     *            The number of chars starting with index to measure
     * @param widths
     *            array to receive the advance widths of the characters. Must be
     *            at least a large as count.
     * @return the actual number of widths returned.
     */
    public int getTextWidths(char[] text, int index, int count, float[] widths) {
        if ((index | count) < 0 || index + count > text.length || count > widths.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (!mHasCompatScaling) {
            return native_getTextWidths(text, index, count, widths);
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        int res = native_getTextWidths(text, index, count, widths);
        setTextSize(oldSize);
        for (int i = 0; i < res; i++) {
            widths[i] *= mInvCompatScaling;
        }
        return res;
    }

    /**
     * Return the advance widths for the characters in the string.
     * 
     * @param text
     *            The text to measure
     * @param start
     *            The index of the first char to to measure
     * @param end
     *            The end of the text slice to measure
     * @param widths
     *            array to receive the advance widths of the characters. Must be
     *            at least a large as (end - start).
     * @return the actual number of widths returned.
     */
    // public int getTextWidths(CharSequence text, int start, int end,
    // float[] widths) {
    // if (text instanceof String) {
    // return getTextWidths((String) text, start, end, widths);
    // }
    // if (text instanceof SpannedString ||
    // text instanceof SpannableString) {
    // return getTextWidths(text.toString(), start, end, widths);
    // }
    // if (text instanceof GraphicsOperations) {
    // return ((GraphicsOperations) text).getTextWidths(start, end,
    // widths, this);
    // }
    //
    // char[] buf = TemporaryBuffer.obtain(end - start);
    // TextUtils.getChars(text, start, end, buf, 0);
    // int result = getTextWidths(buf, 0, end - start, widths);
    // TemporaryBuffer.recycle(buf);
    // return result;
    // }

    /**
     * Return the advance widths for the characters in the string.
     * 
     * @param text
     *            The text to measure
     * @param start
     *            The index of the first char to to measure
     * @param end
     *            The end of the text slice to measure
     * @param widths
     *            array to receive the advance widths of the characters. Must be
     *            at least a large as the text.
     * @return the number of unichars in the specified text.
     */
    public int getTextWidths(String text, int start, int end, float[] widths) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (end - start > widths.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (!mHasCompatScaling) {
            return native_getTextWidths(text, start, end, widths);
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        int res = native_getTextWidths(text, start, end, widths);
        setTextSize(oldSize);
        for (int i = 0; i < res; i++) {
            widths[i] *= mInvCompatScaling;
        }
        return res;
    }

    /**
     * Return the advance widths for the characters in the string.
     * 
     * @param text
     *            The text to measure
     * @param widths
     *            array to receive the advance widths of the characters. Must be
     *            at least a large as the text.
     * @return the number of unichars in the specified text.
     */
    public int getTextWidths(String text, float[] widths) {
        return getTextWidths(text, 0, text.length(), widths);
    }

    /**
     * Return the path (outline) for the specified text. Note: just like
     * Canvas.drawText, this will respect the Align setting in the paint.
     * 
     * @param text
     *            The text to retrieve the path from
     * @param index
     *            The index of the first character in text
     * @param count
     *            The number of characterss starting with index
     * @param x
     *            The x coordinate of the text's origin
     * @param y
     *            The y coordinate of the text's origin
     * @param path
     *            The path to receive the data describing the text. Must be
     *            allocated by the caller.
     */
    // public void getTextPath(char[] text, int index, int count,
    // float x, float y, Path path) {
    // if ((index | count) < 0 || index + count > text.length) {
    // throw new ArrayIndexOutOfBoundsException();
    // }
    // native_getTextPath(mNativePaint, text, index, count, x, y, path.ni());
    // }

    /**
     * Return the path (outline) for the specified text. Note: just like
     * Canvas.drawText, this will respect the Align setting in the paint.
     * 
     * @param text
     *            The text to retrieve the path from
     * @param start
     *            The first character in the text
     * @param end
     *            1 past the last charcter in the text
     * @param x
     *            The x coordinate of the text's origin
     * @param y
     *            The y coordinate of the text's origin
     * @param path
     *            The path to receive the data describing the text. Must be
     *            allocated by the caller.
     */
    // public void getTextPath(String text, int start, int end,
    // float x, float y, Path path) {
    // if ((start | end | (end - start) | (text.length() - end)) < 0) {
    // throw new IndexOutOfBoundsException();
    // }
    // native_getTextPath(mNativePaint, text, start, end, x, y, path.ni());
    // }

    /**
     * Return in bounds (allocated by the caller) the smallest rectangle that
     * encloses all of the characters, with an implied origin at (0,0).
     * 
     * @param text
     *            String to measure and return its bounds
     * @param start
     *            Index of the first char in the string to measure
     * @param end
     *            1 past the last char in the string measure
     * @param bounds
     *            Returns the unioned bounds of all the text. Must be allocated
     *            by the caller.
     */
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (bounds == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetStringBounds(text, start, end, bounds);
    }

    /**
     * Return in bounds (allocated by the caller) the smallest rectangle that
     * encloses all of the characters, with an implied origin at (0,0).
     * 
     * @param text
     *            Array of chars to measure and return their unioned bounds
     * @param index
     *            Index of the first char in the array to measure
     * @param count
     *            The number of chars, beginning at index, to measure
     * @param bounds
     *            Returns the unioned bounds of all the text. Must be allocated
     *            by the caller.
     */
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (bounds == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetCharArrayBounds(text, index, count, bounds);
    }

//    private static native int native_init();
//
//    private static native int native_initWithPaint(int paint);
//
//    private static native void native_reset(int native_object);
//
//    private static native void native_set(int native_dst, int native_src);
//
//    private static native int native_getStyle(int native_object);
//
//    private static native void native_setStyle(int native_object, int style);
//
//    private static native int native_getStrokeCap(int native_object);
//
//    private static native void native_setStrokeCap(int native_object, int cap);
//
//    private static native int native_getStrokeJoin(int native_object);
//
//    private static native void native_setStrokeJoin(int native_object, int join);
//
//    private static native boolean native_getFillPath(int native_object, int src, int dst);
//
//    private static native int native_setShader(int native_object, int shader);
//
//    private static native int native_setColorFilter(int native_object, int filter);
//
//    private static native int native_setXfermode(int native_object, int xfermode);
//
//    private static native int native_setPathEffect(int native_object, int effect);
//
//    private static native int native_setMaskFilter(int native_object, int maskfilter);
//
//    private static native int native_setTypeface(int native_object, int typeface);
//
//    private static native int native_setRasterizer(int native_object, int rasterizer);
//
//    private static native int native_getTextAlign(int native_object);
//
//    private static native void native_setTextAlign(int native_object, int align);
//
//    private static native float native_getFontMetrics(int native_paint, FontMetrics metrics);

    private int native_getTextWidths(char[] text, int index, int count, float[] widths) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

    private int native_getTextWidths(String text, int start, int end, float[] widths) {
        Assert.NOT_IMPLEMENTED();
        return 0;
    }

//    private static native void native_getTextPath(int native_object, char[] text, int index,
//            int count, float x, float y, int path);
//
//    private static native void native_getTextPath(int native_object, String text, int start,
//            int end, float x, float y, int path);

    private void nativeGetStringBounds(String text, int start, int end, Rect bounds) {
        Assert.NOT_IMPLEMENTED();
    }

    private void nativeGetCharArrayBounds(char[] text, int index, int count, Rect bounds) {
        Assert.NOT_IMPLEMENTED();
    }

    public UIFont xmlvmGetUIFont() {
        return (mTypeface == null ? Typeface.create(Typeface.DEFAULT, mFlags) : Typeface.create(mTypeface, mFlags)).xmlvmGetUIFont(mTextSize);
    }

    public float[] xmlvmGetColor() {
        int a = (mColor >> 24) & 0xff;
        int r = (mColor >> 16) & 0xff;
        int g = (mColor >> 8) & 0xff;
        int b = mColor & 0xff;
        float color[] = { r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f };
        return color;
    }

    public void xmlvmSetCGContextParameters(CGContext context) {
        if (mShadowRadius != 0) {
            context.setShadowWithColor(mShadowDX, mShadowDY, mShadowRadius, mShadowColor);
        }
        float[] color = xmlvmGetColor();
        context.setFillColor(color);
        context.setStrokeColor(color);
    }
}
