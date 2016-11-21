import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.faceless.graph2.Align;
import org.faceless.graph2.AreaSeries;
import org.faceless.graph2.AxesGraph;
import org.faceless.graph2.FunctionLineSeries;
import org.faceless.graph2.Key;
import org.faceless.graph2.SVGOutput;
import org.faceless.graph2.Style;
import org.faceless.graph2.TextStyle;

public class DrawSvg {

	public static void main(String args[]) throws IOException {
		AxesGraph graph = new AxesGraph();
		graph.setXRotation(25);
		graph.setYRotation(15);

		// First we create two FunctionLineSeries objects
		//
		FunctionLineSeries sin = new FunctionLineSeries("Sine", 0, 6) {
			public double func(double x) {
				return Math.cos(x) + 2;
			}
		};
		sin.setStyle(new Style(Color.RED));

		FunctionLineSeries cos = new FunctionLineSeries("CoSine", 0, 6) {
			public double func(double x) {
				return Math.sin(x) + 2;
			}
		};
		cos.setStyle(new Style(Color.BLUE));

		// Then we add them to an AreaSeries and add that to the graph.
		//
		AreaSeries series = new AreaSeries("area");
		series.add(cos);
		series.add(sin);
		graph.addSeries(series);

		// Create the key
		//
		Key key = new Key(new Style(Color.WHITE));
		key.addSeries(sin, new TextStyle("Times", 12, Color.BLACK));
		key.addSeries(cos, new TextStyle("Times", 12, Color.BLACK));
		graph.addKey(key, Align.RIGHT);

		// Finally we write the graph to a file.
		//
		// ImageOutput image = new ImageOutput(500,300);
		// graph.draw(image);
		// FileOutputStream out = new FileOutputStream("AreaGraphExample.png");
		// image.writePNG(out, 0);
		// out.close();

		SVGOutput out = new SVGOutput(100, 100);
		graph.draw(out);
		out.writeSVG(new OutputStreamWriter(new FileOutputStream(
				"AreaGraphExample.svg"), "UTF-8"), true);
	}

}
