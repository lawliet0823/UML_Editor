


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLabel;

public class BasicObject extends Shape implements Selectable {

	protected boolean classSelect = false;
	protected Font labelFont = new Font(Font.SERIF, Font.ITALIC, 30);
	protected JLabel jLabel = new JLabel("Object");
	protected String portLocation = "";
	protected Point point = new Point(0, 0);
	protected Point releasedPoint = new Point(0, 0);
	protected Port portBorder = new Port(Color.blue, 10, 10, 10, 2);

	public BasicObject() {

	}

	public void setPoint(int x, int y) {
		point.x = x;
		point.y = y;
	}

	public Point getPoint() {
		return point;
	}

	public void setReleasedPoint(int x, int y) {
		releasedPoint.x = x;
		releasedPoint.y = y;
	}

	public Point getReleasedPoint() {
		return releasedPoint;
	}

	public void setClassName(String args) {
		jLabel.setText(args);
	}

	public String getClassName() {
		return jLabel.getText();
	}

	public void setBorder() {
		if (classSelect) {
			this.setBorder(portBorder);
		} else {
			this.setBorder(null);
		}
	}

	public String getPortLocation() {
		double minimum1, minimum2, minimum3, minimum4, minimum5, minimum6, minimum7;
		minimum1 = this.getDistance(point.x + 100, point.y, releasedPoint.x,
				releasedPoint.y);
		minimum2 = this.getDistance(point.x + 200, point.y + 100,
				releasedPoint.x, releasedPoint.y);
		minimum3 = this.getDistance(point.x + 100, point.y + 200,
				releasedPoint.x, releasedPoint.y);
		minimum4 = this.getDistance(point.x, point.y + 100, releasedPoint.x,
				releasedPoint.y);
		minimum5 = Math.min(minimum1, minimum2);
		minimum6 = Math.min(minimum3, minimum4);
		minimum7 = Math.min(minimum5, minimum6);
		if (minimum1 == minimum7) {
			portLocation = "up";
		} else if (minimum2 == minimum7) {
			portLocation = "right";
		} else if (minimum3 == minimum7) {
			portLocation = "down";
		} else if (minimum4 == minimum7) {
			portLocation = "left";
		}
		return portLocation;
	}

	public double getDistance(int x1, int y1, int x2, int y2) {
		double distance = 0;
		distance = Math.pow(Math.abs(x1 - x2), 2)
				+ Math.pow(Math.abs(y1 - y2), 2);
		return distance;
	}

	@Override
	public boolean getSelectable() {
		// TODO Auto-generated method stub
		return classSelect;
	}

	@Override
	public void setSelectable(boolean args) {
		// TODO Auto-generated method stub
		classSelect = args;
	}
	
	public void setObjectBorder(){
		
	}
}
