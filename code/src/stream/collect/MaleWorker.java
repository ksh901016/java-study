package stream.collect;

import stream.Worker;

import java.util.ArrayList;
import java.util.List;

public class MaleWorker {
    private List<Worker> list; // 저장할 컬렉션

    public MaleWorker(){
        list = new ArrayList<>();
        System.out.println("[" + Thread.currentThread().getName() + "] MaleWorker()");
    }

    public void accumulate(Worker worker){ // 요소를 수집하는 메소드
        list.add(worker);
        System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
    }

    public void combine(MaleWorker other){ // 두 MaleWorker를 결합
        list.addAll(other.getList());
        System.out.println("[" + Thread.currentThread().getName() + "] combine()");
    }

    public List<Worker> getList() {
        return list;
    }
}
