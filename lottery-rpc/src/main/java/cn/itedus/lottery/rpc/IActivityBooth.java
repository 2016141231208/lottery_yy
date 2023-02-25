package cn.itedus.lottery.rpc;

import cn.itedus.lottery.rpc.req.ActivityReq;
import cn.itedus.lottery.rpc.res.ActivityRes;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 *
 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 */

/*对于接口需要有实现类，IActivityBooth的实现类在interface的ActivityBooth类中
有一些功能，不仅仅是一个类去实现，即有很多地方有用到，大家需要统一标准。所以需要用接口，这样大家同时实现一个接口，就能够统一规范。在接口中只是定义了基本的方法名，具体的实现交给实现类。
统一标准之后的下一件事情，就是多态。多态的实现，是使用了动态绑定技术，这里不做进一步展开。只需要知道在C和C++中，是前期绑定，也就是在编译前，就已经知道了具体执行哪些代码；而在java中，是后期绑定或者说是动态绑定，也就是在程序执行的那一刻，才会知道执行什么代码。而动态绑定技术，是实现多态的重要条件。
 */
public interface IActivityBooth {

    ActivityRes queryActivityById(ActivityReq req);

}
