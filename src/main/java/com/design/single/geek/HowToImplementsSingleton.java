package com.design.single.geek;

/**
 * 如何实现单例模式：<br/>
 * - 构造函数需要是 private 访问权限的，这样才能避免外部通过 new 创建实例；<br/>
 * - 考虑对象创建时的线程安全问题；<br/>
 * - 考虑是否支持延迟加载；<br/>
 * - 考虑 getInstance() 性能是否高（是否加锁）。<br/>
 * <p>
 * ------------------------------------------------------<br/>
 * - 饿汉式：类加载时，instance静态实例就已经创建并初始化好了~<br/>
 * - 如果初始化耗时长，那我们最好不要等到真正要用它的时候，才去执行这个耗时长的初始化过程，这会影响到系统的性能
 * - 如果实例占用资源多，按照 fail-fast 的设计原则（有问题及早暴露），那我们也希望在程序启动时就将这个实例初始化好。<br/>
 * 如果资源不够，就会在程序启动的时候触发报错（比如Java 中的 PermGen Space OOM），我们可以立即去修复。这样也能避<br/>
 * 免在程序运行一段时间后，突然因为初始化这个实例占用资源过多，导致系统崩溃，影响系统的可用性。<br/>
 * 所以在这类情况下我觉得饿汉式比懒汉式好
 */
public class HowToImplementsSingleton {
}
