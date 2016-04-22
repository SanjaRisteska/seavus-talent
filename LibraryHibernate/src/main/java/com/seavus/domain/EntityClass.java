package com.seavus.domain;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class EntityClass {
	@Id
	@GeneratedValue
	protected Long id;
}
