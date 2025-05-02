import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val plus_circled: ImageVector
	get() {
		if (_undefined != null) {
			return _undefined!!
		}
		_undefined = ImageVector.Builder(
            name = "PlusCircled",
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
				moveTo(1.82707f, 7.49972f)
				curveTo(1.8271f, 4.3667f, 4.3669f, 1.8269f, 7.4999f, 1.8269f)
				curveTo(10.6329f, 1.8269f, 13.1727f, 4.3667f, 13.1727f, 7.4997f)
				curveTo(13.1727f, 10.6327f, 10.6329f, 13.1726f, 7.4999f, 13.1726f)
				curveTo(4.3669f, 13.1726f, 1.8271f, 10.6327f, 1.8271f, 7.4997f)
				close()
				moveTo(7.50003f, 4f)
				curveTo(7.7762f, 4f, 8f, 4.2239f, 8f, 4.5f)
				verticalLineTo(7f)
				horizontalLineTo(10.5f)
				curveTo(10.7762f, 7f, 11f, 7.2239f, 11f, 7.5f)
				curveTo(11f, 7.7761f, 10.7762f, 8f, 10.5f, 8f)
				horizontalLineTo(8.00003f)
				verticalLineTo(10.5f)
				curveTo(8f, 10.7761f, 7.7762f, 11f, 7.5f, 11f)
				curveTo(7.2239f, 11f, 7f, 10.7761f, 7f, 10.5f)
				verticalLineTo(8f)
				horizontalLineTo(4.50003f)
				curveTo(4.2239f, 8f, 4f, 7.7761f, 4f, 7.5f)
				curveTo(4f, 7.2239f, 4.2239f, 7f, 4.5f, 7f)
				horizontalLineTo(7.00003f)
				verticalLineTo(4.5f)
				curveTo(7f, 4.2239f, 7.2239f, 4f, 7.5f, 4f)
				close()
			}
		}.build()
		return _undefined!!
	}

private var _undefined: ImageVector? = null
