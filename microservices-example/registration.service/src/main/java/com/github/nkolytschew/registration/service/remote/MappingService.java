package com.github.nkolytschew.registration.service.remote;

import com.github.nkolytschew.registration.service.jpa.entity.User;
import com.github.nkolytschew.registration.service.rest.model.MyUser;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface MappingService {

    /**
     * user {@link Resource} as a placeholder
     * in the end, spring will render this response as a JSON
     * <p>
     * internal representation is {@link java.io.InputStream}
     *
     * @return
     */
    ResponseEntity<MyUser> mapToApiResponse(User entity);

    ResponseEntity<User> mapFromApiToEntity(MyUser user);

}
