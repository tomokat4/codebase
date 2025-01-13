class Rectangle{
    //default values of class
    double width;
    double height;

    ///constructors

    //no arg constructor
    Rectangle(){
        width = 1;
        height = 1;
    }

    //arg constructor
    Rectangle(double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
    }
    
    ///methods

    double getArea(){
        return width * height;
    }

    double getPerimeter(){
        return width*2 + height*2;
    }
    
    void setWidth(double newWidth){
        width = newWidth;
    }

    void setHeight(double newHeight){
        height = newHeight;
    }
}