class Rectangle:
    def __init__(self, width=0, height=0):
        self.__width = width
        self.__height = height

    def get_width(self):
        return self.__width

    def set_width(self, width):
        if width >= 0:
            self.__width = width
        else:
            print("Ширина не может быть отрицательной.")

    def get_height(self):
        return self.__height

    def set_height(self, height):
        if height >= 0:
            self.__height = height
        else:
            print("Высота не может быть отрицательной.")

    def calculate_area(self):
        return self.__width * self.__height

    def calculate_perimeter(self):
        return 2 * (self.__width + self.__height)

# Пример использования:
rectangle1 = Rectangle(5, 4)
print("Ширина:", rectangle1.get_width())
print("Высота:", rectangle1.get_height())
print("Площадь:", rectangle1.calculate_area())
print("Периметр:", rectangle1.calculate_perimeter())

# Изменение ширины и высоты с использованием сеттеров:
rectangle1.set_width(6)
rectangle1.set_height(8)
print("Измененная ширина:", rectangle1.get_width())
print("Измененная высота:", rectangle1.get_height())
