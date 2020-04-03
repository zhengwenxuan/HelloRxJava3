import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloRx {
    public static void main(String[] args) {
        Observable.create(emitter->{//emitter
                    emitter.onNext("hello");
                    emitter.onNext("world");
                    emitter.onNext("welcome");
                })
                .observeOn(Schedulers.newThread())
                .subscribe(o-> System.out.println(Thread.currentThread().getName()+":"+o));
        Observable.create(emitter->{//
                    emitter.onNext("hello");
                    emitter.onNext("world");
                    emitter.onNext("welcome");
                })
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer(){
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }
                    @Override
                    public void onNext(Object o) {
                        System.out.println(Thread.currentThread().getName()+":"+o);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
        for(;;);//Schedulers.newThread()新启的是守护线程
    }
}
