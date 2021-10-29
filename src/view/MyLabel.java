package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1786577709189595916L;
	private boolean selected = false;
	private boolean pressed = false;
	private boolean hover = false;
	private ImageIcon deficon = new ImageIcon("src/Images/defaultbutton.png");
	//private ImageIcon hovericon;
	private ImageIcon pressedicon = new ImageIcon("src/Images/clickedbutton.png");

	public MyLabel() {
		super();
		setIcon(deficon);
	}

	public MyLabel(String txt) {
		super(txt);
		setIcon(deficon);
	}

	public void setSelected() {
		selected = !selected;
		//System.out.println("click");
		if (selected) {
			setIcon(pressedicon);
		} else {
			setIcon(deficon);
		}
	}

	public void setSelected(boolean select) {
		selected = select;
		//System.out.println("click");
		if (selected) {
			setIcon(pressedicon);
		} else {
			setIcon(deficon);
		}
	}
	
	public boolean isSelected(){
		return selected;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}

}
