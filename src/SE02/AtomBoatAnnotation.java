package SE02;
import java.lang.annotation.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Avdeeva Elena on 18/04/2018.
 */

/**
 * Documentation for Class АтомнаяЛодка
 */


@Documented
@Inherited

@Retention(RetentionPolicy.RUNTIME)
/**
 *
 */
public @interface AtomBoatAnnotation {

    String name();
    int id();
}
