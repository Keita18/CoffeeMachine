class Complex {

    double real;
    double image;

    // write methods here
    void add(Complex complex) {
        this.real = this.real + complex.real;
        this.image = this.image + complex.image;
    }

    void subtract(Complex complex) {
        this.real = this.real - complex.real;
        this.image = this.image - complex.image;
    }
}