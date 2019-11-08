public class Sequence extends Star{
    Sequence seq;
    private String name;
    private double mass;
    private double size;

    public Sequence(String name, double mass, double size){
        super(name,mass,size);
    }

    public boolean isSun(){
        return (super.getMass() == 2 && super.getSize() == 430);
    }

    @Override
    public boolean isBlackHole() {
        return super.getMass() > 1000 && super.getSize() < 50;
    }

    @Override
    public String toString() {
        return "< "+super.getName()+" >: A Sequence Star with mass = < "+super.getMass()+" > KG; Size = < "+super.getSize()+" > miles";
    }
}
