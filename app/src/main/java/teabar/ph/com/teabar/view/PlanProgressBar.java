package teabar.ph.com.teabar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import teabar.ph.com.teabar.R;

public class PlanProgressBar extends View {

    private Paint paint;// 画笔
    private Paint paint1;// 画笔
    private int progress;// 进度值
    private int width;// 宽度值
    private int height;// 高度值

    public PlanProgressBar(Context context, AttributeSet attrs,
                           int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PlanProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlanProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint1 = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth() - 1;// 宽度值
        height = getMeasuredHeight() - 1;// 高度值
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.nomal_green));// 设置画笔颜色
        paint1.setColor(Color.parseColor("#3DBBBBBB"));

//        if (progress==100){
//            canvas.drawRoundRect(0, 0, width - progress / 100f * width, height,30,30,
//                    paint);// 画矩形
//        }else {
//            if (progress < 2) {
//                canvas.drawRoundRect(6, height - progress / 100f * height, width - 6, height, 10, 10,
//                        paint);// 画矩形
//            } else if (progress == 2) {
//                canvas.drawRoundRect(4, height - progress / 100f * height, width - 4, height, 10, 10,
//                        paint);// 画矩形
//                canvas.drawRect(2, height - progress / 100f * height, width - 2, height - progress / 100f * height + 2,
//                        paint);// 画矩形
//            }
//
//            else {
//                canvas.drawRect(20, 0, width - progress / 100f * width+5, height ,
//                        paint);// 画矩形
//                canvas.drawRoundRect(0, 0, width - progress / 100f * width, height,30,30,
//                        paint);// 画矩形
//            }
//        }

//        canvas.drawRect(0, height - progress / 100f * height, width, height,
//                paint);// 画矩形
        canvas.drawRoundRect(width-progress / 100f * width-13, 0, width, height,11,11,
                paint1);// 画矩形
        canvas.drawRoundRect(0, 0, width-progress / 100f * width, height, 11, 11,
                        paint);// 画矩形


//        canvas.drawLine(0, 0, width, 0, paint);// 画顶边
//        canvas.drawLine(0, 0, 0, height, paint);// 画左边
//        canvas.drawLine(width, 0, width, height, paint);// 画右边
//        canvas.drawLine(0, height, width, height, paint);// 画底边

//        paint.setColor(Color.RED);// 设置画笔颜色为红色
//        paint.setTextSize(width / 3);// 设置文字大小
//        canvas.drawText(progress + "%",
//                (width - getTextWidth(progress + "%")) / 2, height / 2, paint);// 画文字
        super.onDraw(canvas);
    }

    /**
     * 拿到文字宽度
     * @param str 传进来的字符串
     * return 宽度
     */
    private int getTextWidth(String str) {
        // 计算文字所在矩形，可以得到宽高
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    /** 设置progressbar进度 */
    public void setProgress(int progress) {
        this.progress =100- progress;
        postInvalidate();
    }
}