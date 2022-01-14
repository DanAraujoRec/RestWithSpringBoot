package br.com.dansa.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <D, O> D parseObject(O origem, Class<D> destination) {
		
		return mapper.map(origem, destination);
		
	}
	
	public static <D, O> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		
		List<D> destinationObject = new ArrayList<D>();
		
		for(Object objectOrigem : origin) {
			destinationObject.add(mapper.map(objectOrigem, destination));
		}
		
		return destinationObject;
		
	}

}
