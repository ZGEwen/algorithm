package stackandqueue;

import pojo.Cat;
import pojo.Dog;
import pojo.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname DogAndCatQueue
 * @Created by zgw
 * @Date 2018-12-03 10:46
 * @Description
 * 实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
 * 实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
 * 的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
 * 进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
 * 例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
 * 否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
 * 类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 * 使用时间戳记录猫狗分别入队列的时间
 */
public class DogAndCatQueue {

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue {

        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DogCatQueue() {
            this.dogQ = new LinkedList<PetEnter>();
            this.catQ = new LinkedList<PetEnter>();
            this.count = 0;
        }

        public void add(Pet pet) {
            //只要有宠物进来，数量就++
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("err, not dog or cat");
            }
        }

        /**
         * 从猫和狗的两个队列中，选出最早的出队
         * @return
         */
        public Pet pollAll() {
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty!");
            }
        }

        public Dog pollDog() {
            if (!this.isDogQueueEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatQueueEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else
                throw new RuntimeException("Cat queue is empty!");
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }

}
