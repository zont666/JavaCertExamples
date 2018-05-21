package datetime.temporal.family;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class FamilyVacations implements TemporalQuery<Boolean> {

  @Override
  public Boolean queryFrom( TemporalAccessor date ) {
    int month = date.get( ChronoField.MONTH_OF_YEAR );
    int day = date.get( ChronoField.DAY_OF_MONTH );

    if ( month == Month.APRIL.getValue() && day >= 3 && day <= 8 ) {
      return Boolean.TRUE;
    }

    if ( month == Month.AUGUST.getValue() && day >= 8 && day <= 14 ) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

}
