package tw.com.test.countobserverdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountObservable count = new CountObservable();
        count.addObserver(new CountObserver());
        count.setCount(1);
        count.setCount(2);
        count.setCount(1);
    }
    public static class CountObservable extends Observable {
        private int count;
        public void setCount(int c){
            count += c;
            setChanged();//一定要標記這個方法 不然無法不會發出通知
//            notifyObservers();//通知所有的觀察者
            notifyObservers(count);
        }
    }

    public class CountObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("count = " + arg);
        }
    }
}
