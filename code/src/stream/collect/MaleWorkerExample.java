package stream.collect;

import stream.Worker;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MaleWorkerExample {
    public static void main(String[] args) {
        List<Worker> totalList = Arrays.asList(
                new Worker("강성현", 30, Worker.Sex.MALE),
                new Worker("여자강성현", 25, Worker.Sex.FEMALE),
                new Worker("깡냉", 20, Worker.Sex.MALE),
                new Worker("까랭", 50, Worker.Sex.FEMALE)
        );

        Stream<Worker> totalStream = totalList.stream();
        Stream<Worker> maleStream = totalStream.filter(s -> s.getSex() == Worker.Sex.MALE);

        Supplier<MaleWorker> supplier = ()->new MaleWorker();
        BiConsumer<MaleWorker, Worker> accumlator = (mw, w) -> mw.accumulate(w);
        BiConsumer<MaleWorker, MaleWorker> combiner = (mw1, mw2) -> mw1.combine(mw2);

        MaleWorker maleWorker = maleStream.collect(supplier, accumlator, combiner);
    }
}
