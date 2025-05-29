public class DataCenterMonitoringSystem {
    public static void main(String[] args) {
        // 创建温度传感器，设置阈值为40°C
        TemperatureSensor sensor = new TemperatureSensor(40);

        // 创建各种响应设备
        Observer warningLight = new WarningLight();
        Observer alarm = new Alarm();
        Observer escapeDoor = new EscapeDoor();
        Observer heatDoor = new HeatDoor();

        // 注册观察者
        sensor.registerObserver(warningLight);
        sensor.registerObserver(alarm);
        sensor.registerObserver(escapeDoor);
        sensor.registerObserver(heatDoor);

        // 模拟温度变化
        System.out.println("当前温度: 35°C");
        sensor.setTemperature(35);

        System.out.println("\n当前温度: 42°C");
        sensor.setTemperature(42);

        System.out.println("\n当前温度: 45°C");
        sensor.setTemperature(45);

        // 移除一个观察者测试
        sensor.removeObserver(alarm);
        System.out.println("\n移除了报警器后，温度: 43°C");
        sensor.setTemperature(43);
    }
}