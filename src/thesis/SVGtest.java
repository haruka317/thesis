package thesis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SVGtest extends JPanel{

	private static final long serialVersionUID = 1L;
	private List<Shape> sp;
	private boolean isPress=false;
	private Point pos0=null;
	private Point pos1=null;
	private BasicStroke stroke=new BasicStroke(2.0f);

	public SVGtest() {
		super();
		super.setOpaque(false);
		sp=new ArrayList<Shape>();
		MouseAdapter ma=new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e) {
				if(isPress){
					pos1=e.getPoint();
					updateUI();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				isPress=true;
				pos0=e.getPoint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				isPress=false;
				if(pos0!=null&&pos1!=null){
					sp.add(new Line2D.Double(pos0.x,pos0.y,pos1.x,pos1.y));
				}
				pos0=null;
				pos1=null;
			}

		};
		addMouseListener(ma);
		addMouseMotionListener(ma);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(stroke);
		g2.setColor(Color.RED);
		for(int i=0;i<sp.size();i++){
			g2.draw(sp.get(i));
		}
		if(pos0!=null&&pos1!=null){
			g2.drawLine(pos0.x, pos0.y, pos1.x, pos1.y);
		}
	}

	void outputSVG(File f){
		Rectangle r=getBounds();
		DOMImplementation domImpl=GenericDOMImplementation.getDOMImplementation();
		Document document=domImpl.createDocument(null, "svg", null);
		SVGGraphics2D svg2d=new SVGGraphics2D(document);
		svg2d.setBackground(new Color(255,255,255,0));
		svg2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		this.paintComponent(svg2d);
		Element sv=svg2d.getRoot();
		sv.setAttribute("xml:space", "preserve");
		sv.setAttribute("width", Integer.toString((int)r.getWidth()));
		sv.setAttribute("height", Integer.toString((int)r.getHeight()));
		sv.setAttribute("viewBox",
				Integer.toString((int)r.getX())+" "+
				Integer.toString((int)r.getY())+" "+
				Integer.toString((int)r.getWidth())+" "+
				Integer.toString((int)r.getHeight())
		);
		try {
    		OutputStream os = new FileOutputStream(f);
    	    BufferedOutputStream bos = new BufferedOutputStream(os);
    	    Writer out = new OutputStreamWriter(bos, "UTF-8");
    	    svg2d.stream(sv,out);
		} catch (UnsupportedEncodingException ue){
    		ue.printStackTrace();
    	} catch (SVGGraphics2DIOException se){
    		se.printStackTrace();
    	} catch (IOException ioe){
    		ioe.printStackTrace();
    	}
	}
}