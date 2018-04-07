package com.csy.annocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 项目名称：springbasic
 * 类名称：
 * 类描述：
 * 创建时间：2016年01月27日 下午23:59
 *
 * @author csypc
 * @version 1.0
 */
@Target(value={ElementType.ANNOTATION_TYPE,ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation2 {
}
