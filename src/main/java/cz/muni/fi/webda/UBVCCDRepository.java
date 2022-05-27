package cz.muni.fi.webda;

import cz.muni.fi.webda.impl.UBVCCD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UBVCCDRepository extends CrudRepository<UBVCCD, Integer> {
}
