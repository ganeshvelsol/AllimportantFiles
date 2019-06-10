package gif.ganesh.pushnotififirebase.workingWithDrawing;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.view.MotionEvent;
        import android.view.View;

        import java.util.ArrayList;
        import java.util.List;

public class PaintView extends View  //implements View.OnTouchListener
{
    private Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();

    public PaintView(Context context)
    {
        super(context);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas c)
    {
        c.drawPath(path, brush);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}
