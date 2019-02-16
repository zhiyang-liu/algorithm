package 栈和队列.catanddogqueue;

public class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public int getCount(){
        return count;
    }

    public String getEnterPetType(){
        return pet.getPetType();
    }
}
