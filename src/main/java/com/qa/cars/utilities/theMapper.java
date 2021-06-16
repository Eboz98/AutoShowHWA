package com.qa.cars.utilities;

public interface theMapper<E, D> {

	D mapToDTO(E entity);

	E mapFromDTO(D dto);
}
