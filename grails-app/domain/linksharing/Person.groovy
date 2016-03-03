package linksharing

class Person {

    String name
    int age

    static constraints = {
    }

    String toString(){
        "${name} ----  ${age}"
    }
}
