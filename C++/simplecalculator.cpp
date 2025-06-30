#include <iostream>
using namespace std;

int main() {
    char op;
    double a, b;
    cout << "Enter an operator (+ - * /): ";
    cin >> op;
    cout << "Enter two numbers: ";
    cin >> a >> b;

    switch(op) {
        case '+': cout << "Result: " << a + b; break;
        case '-': cout << "Result: " << a - b; break;
        case '*': cout << "Result: " << a * b; break;
        case '/':
            if (b != 0) cout << "Result: " << a / b;
            else cout << "Cannot divide by zero";
            break;
        default: cout << "Invalid operator";
    }
    return 0;
}
