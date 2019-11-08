public class RedGiant extends Star {

    public RedGiant(String name, double mass, double size){super(name,mass,size);}

    public boolean isSuperGiant(){
        return (super.getMass()>100 && super.getSize()>100);
    } //Return true if mass > 100 and size > 100, otherwise false.

    @Override
    public boolean isBlackHole() {
        return isSuperGiant();
    }

    @Override
    public String toString() {
        if(isSuperGiant()){
            return "< "+super.getName()+" >: A SuperGiant with mass = < "+super.getMass()+" > KG; Size = < "+super.getSize()+" > miles";
        }
        return "< "+super.getName()+" >: A RedGiant with mass = < "+super.getMass()+" > KG; Size = < "+super.getSize()+" > miles";
    }
}
