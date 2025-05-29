import java.util.ArrayList;
import java.util.List;

// 观察者接口
interface Observer {
    void update(double temperature);
}

// 被观察者接口
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 温度传感器（被观察者）
class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private double currentTemperature;
    private double thresholdTemperature;

    public TemperatureSensor(double threshold) {
        this.thresholdTemperature = threshold;
    }

    public void setTemperature(double temperature) {
        this.currentTemperature = temperature;
        if (temperature >= thresholdTemperature) {
            notifyObservers();
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentTemperature);
        }
    }
}

// 警示灯
class WarningLight implements Observer {
    @Override
    public void update(double temperature) {
        System.out.println("警示灯: 温度达到 " + temperature + "°C，开始闪烁！");
    }
}

// 报警器
class Alarm implements Observer {
    @Override
    public void update(double temperature) {
        System.out.println("报警器: 温度达到 " + temperature + "°C，发出警报声！");
    }
}

// 安全逃生门
class EscapeDoor implements Observer {
    @Override
    public void update(double temperature) {
        System.out.println("安全逃生门: 温度达到 " + temperature + "°C，自动开启！");
    }
}

// 隔热门
class HeatDoor implements Observer {
    @Override
    public void update(double temperature) {
        System.out.println("隔热门: 温度达到 " + temperature + "°C，自动关闭！");
    }
}