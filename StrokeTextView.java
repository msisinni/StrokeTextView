
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class StrokeTextView extends TextView {
	private static final String TAG = "StrokeTextView";
	private TextPaint mStrokePaint = new TextPaint();
	private TextPaint mWordsPaint = new TextPaint();


	public StrokeTextView(Context context) {
		this(context, null);
	}

	public StrokeTextView(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.textViewStyle);
	}

	public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);


		final int strokeWidth = (int) (getTextSize() / 5);

		mStrokePaint.setARGB(255, 0, 0, 0);
		mStrokePaint.setTypeface(Typeface.DEFAULT_BOLD);
		mStrokePaint.setStyle(Paint.Style.STROKE);
		mStrokePaint.setStrokeWidth(strokeWidth);
		mStrokePaint.setAntiAlias(true);
		mStrokePaint.setTextScaleX(getTextScaleX());

		mWordsPaint.setARGB(255, 255, 255, 255);
		mWordsPaint.setTypeface(Typeface.DEFAULT_BOLD);
		mWordsPaint.setAntiAlias(true);
		mWordsPaint.setTextScaleX(getTextScaleX());


	}


	@Override
	public boolean onPreDraw() {
		return super.onPreDraw();
	}

	@Override
	@SuppressLint("DrawAllocation")
	protected void onDraw(@NonNull Canvas canvas) {

		canvas.save();

		mStrokePaint.setTextSize(getTextSize());
		mWordsPaint.setTextSize(getTextSize());

		StaticLayout strokeLayout = new StaticLayout(getText(), mStrokePaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
		StaticLayout wordsLayout = new StaticLayout(getText(), mWordsPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

		strokeLayout.draw(canvas);
		wordsLayout.draw(canvas);

		canvas.restore();
	}

	/**
	 * TODO:
	 * -make DynamicLayout give room for stroke;
	 */
}
