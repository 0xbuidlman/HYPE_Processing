package hype.drawable;

import hype.util.H;
import processing.core.PGraphics;

public class HGroup extends HDrawable {
	
	@Override
	public HGroup createCopy() {
		HGroup copy = new HGroup();
		copy.copyPropertiesFrom(this);
		return copy;
	}
	
	@Override
	public void paintAll(PGraphics g, float currAlphaPerc) {
		if(_alpha<=0) return;
		
		// Perform a trimmed down version of super.paintAll()�
		g.pushMatrix();
			if(H.uses3D()) g.translate(_x,_y,_z);
			else g.translate(_x,_y);
			g.rotate(_rotationRad);
			
			currAlphaPerc *= _alpha;
			
			HDrawable child = _firstChild;
			while(child != null) {
				child.paintAll(g,currAlphaPerc);
				child = child.next();
			}
		g.popMatrix();
	}
	
	@Override
	public void draw(PGraphics g,float drawX,float drawY,float currAlphaPerc) {}
}
