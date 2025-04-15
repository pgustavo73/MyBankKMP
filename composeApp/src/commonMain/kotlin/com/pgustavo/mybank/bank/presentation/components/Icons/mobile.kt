import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val mobile: ImageVector
	get() {
		if (_Mobile != null) {
			return _Mobile!!
		}
		_Mobile = ImageVector.Builder(
            name = "Mobile",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
			path(
    			fill = SolidColor(Color(0xFF000000)),
    			fillAlpha = 1.0f,
    			stroke = null,
    			strokeAlpha = 1.0f,
    			strokeLineWidth = 1.0f,
    			strokeLineCap = StrokeCap.Butt,
    			strokeLineJoin = StrokeJoin.Miter,
    			strokeLineMiter = 1.0f,
    			pathFillType = PathFillType.EvenOdd
			) {
				moveTo(4f, 2.5f)
				curveTo(4f, 2.2239f, 4.2239f, 2f, 4.5f, 2f)
				horizontalLineTo(10.5f)
				curveTo(10.7761f, 2f, 11f, 2.2239f, 11f, 2.5f)
				verticalLineTo(12.5f)
				curveTo(11f, 12.7761f, 10.7761f, 13f, 10.5f, 13f)
				horizontalLineTo(4.5f)
				curveTo(4.2239f, 13f, 4f, 12.7761f, 4f, 12.5f)
				verticalLineTo(2.5f)
				close()
				moveTo(4.5f, 1f)
				curveTo(3.6716f, 1f, 3f, 1.6716f, 3f, 2.5f)
				verticalLineTo(12.5f)
				curveTo(3f, 13.3284f, 3.6716f, 14f, 4.5f, 14f)
				horizontalLineTo(10.5f)
				curveTo(11.3284f, 14f, 12f, 13.3284f, 12f, 12.5f)
				verticalLineTo(2.5f)
				curveTo(12f, 1.6716f, 11.3284f, 1f, 10.5f, 1f)
				horizontalLineTo(4.5f)
				close()
				moveTo(6f, 11.65f)
				curveTo(5.8067f, 11.65f, 5.65f, 11.8067f, 5.65f, 12f)
				curveTo(5.65f, 12.1933f, 5.8067f, 12.35f, 6f, 12.35f)
				horizontalLineTo(9f)
				curveTo(9.1933f, 12.35f, 9.35f, 12.1933f, 9.35f, 12f)
				curveTo(9.35f, 11.8067f, 9.1933f, 11.65f, 9f, 11.65f)
				horizontalLineTo(6f)
				close()
			}
		}.build()
		return _Mobile!!
	}

private var _Mobile: ImageVector? = null
