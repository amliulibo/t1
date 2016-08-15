package polymorphism;

public class PloyConstructor {
	public static void main(String[] args)
	{
		new RoundGlyph(5);
	}
}
class Glyph{
	public  void  draw(){ System.out.println("Glyph.draw()"); }
	public Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() before draw()");
	}
}
class RoundGlyph extends Glyph{
	private int radius=1;
	public RoundGlyph(int radius)
	{
		this.radius=radius;
		draw();
	}
	public void draw(){ System.out.println("RoundGlyph.draw(),radius="+radius); }
}