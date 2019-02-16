package 栈和队列.catanddogqueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private int count;

    public DogCatQueue(){
        dogQueue = new LinkedList<PetEnterQueue>();
        catQueue = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if (pet.getPetType().equals("dog")) {
            dogQueue.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            catQueue.add(new PetEnterQueue(pet, this.count++));
        }
    }

    /**
     * 获取最后一个进队的宠物，不管是cat or dog
     * @return
     */
    public Pet pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.poll().getCount() > catQueue.poll().getCount()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("que is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.dogQueue.isEmpty()) {
            return (Dog)dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.catQueue.isEmpty()) {
            return (Cat)catQueue.poll().getPet();
        } else {
            throw new RuntimeException("cat queue is empty!");
        }
    }

    public boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }
}
