package lab2;

public class Main {
    public static void main(String[] args) {
        //объявление экземпляра класса Point2d
        Point2d myPoint = new Point2d();//создание точки (0;0)
        Point2d myOtherPoint = new Point2d(5, 3);//создание точки (5;3)
        Point2d aThirdPoint = new Point2d();

        //объявление экземпляра класса Point3d
        Point3d point3d = new Point3d();//создание точки (0;0;0)
        Point3d other3d = new Point3d(5, 3, 2);//создание точки (5;3;2)

        //получение и изменение координат в точках типа Point2d и Point2d
        System.out.println("Точка 1 имеет координаты: x="+myPoint.getX()+", y="+myPoint.getY());
        myPoint.setX(4);
        myPoint.setY(8);
        System.out.println("Точка 1 имеет координаты: x="+myPoint.getX()+", y="+myPoint.getY());
        System.out.println("Точка 2 имеет координаты: x="+point3d.getX()+", y="+point3d.getY()+", z="+point3d.getZ());
        point3d.setX(9);
        point3d.setY(2);
        point3d.setZ(4);
        System.out.println("Точка 2 имеет координаты: x="+myPoint.getX()+", y="+myPoint.getY()+", z="+point3d.getZ());

    }
}
