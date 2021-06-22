package com.david.demo.source.reader.converter;

//import org.springframework.core.convert.TypeDescriptor;
//import org.springframework.core.convert.converter.ConditionalGenericConverter;
//import org.springframework.core.convert.support.CollectionToCollectionConverter;
//import org.springframework.core.convert.support.DefaultConversionService;
//import org.springframework.core.convert.support.StreamConverter;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/6/21 23:21
 */
public class ConverterTest {
	public static void main(String[] args) {
//		ConditionalGenericConverter converter = new StreamConverter(new DefaultConversionService());
//
//		System.out.println("----------------CollectionToCollectionConverter---------------");
//		ConditionalGenericConverter conditionalGenericConverter = new CollectionToCollectionConverter(new DefaultConversionService());
////		ConditionalGenericConverter conditionalGenericConverter = null;
//
//		// 将Collection转为Collection（注意：没有指定泛型类型哦）
//		System.out.println(conditionalGenericConverter.getConvertibleTypes());
//
//		List<String> sourceList = Arrays.asList("1", "2", "2", "3", "4");
//		TypeDescriptor sourceTypeDesp = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class));
//		TypeDescriptor targetTypeDesp = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(Integer.class));
//
//		System.out.println(conditionalGenericConverter.matches(sourceTypeDesp, targetTypeDesp));
//		Object convert = conditionalGenericConverter.convert(sourceList, sourceTypeDesp, targetTypeDesp);
//		System.out.println(convert.getClass());
//		System.out.println(convert);
	}
}
