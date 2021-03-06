package com.design.single.geek;

/**
 * 网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被
 * new 出来，并且赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻
 * 辑），就被另一个线程使用了。
 * 要解决这个问题，我们需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才
 * 行。实际上，只有很低版本的 Java 才会有这个问题。我们现在用的高版本的 Java 已经在
 * JDK 内部实现中解决了这个问题（解决的方法很简单，只要把对象 new 操作和初始化操作
 * 设计为原子操作，就自然能禁止重排序）。关于这点的详细解释，跟特定语言有关，我就不
 * 展开讲了，感兴趣的同学可以自行研究一下。
 */
public class DCLSingleton {
    private static volatile DCLSingleton instance = null;

    public DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

}
