

import java.awt.*;
import java.applet.*;

public class button extends Applet{
	public void init(){
		BorderLayout setLayout = (new BorderLayout());
			Button Easy = new Button("Easy");
			Button Normal = new Button("Normal");
			Button Hard = new Button("Hard");
				add(Easy,"North" );
				add(Normal, "East");
				add(Hard, "South");
	}
}
