package datetime.temporal.family;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;

public final class ImportantFamilyDates {

  private ImportantFamilyDates() {

  }

  static final TemporalQuery<Boolean> FAMILY_BIRTHDAY = date -> {
    int month = date.get( ChronoField.MONTH_OF_YEAR );
    int day = date.get( ChronoField.DAY_OF_MONTH );

    if ( month == Month.APRIL.getValue() && day == 3 ) {
      return Boolean.TRUE;
    }

    if ( month == Month.JUNE.getValue() && day == 18 ) {
      return Boolean.TRUE;
    }

    if ( month == Month.MAY.getValue() && day == 29 ) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  };

  static final TemporalQuery<Boolean> FAMILY_VACATION = date -> {
    int month = date.get( ChronoField.MONTH_OF_YEAR );
    int day = date.get( ChronoField.DAY_OF_MONTH );

    if ( month == Month.APRIL.getValue() && day >= 3 && day <= 8 ) {
      return Boolean.TRUE;
    }

    if ( month == Month.AUGUST.getValue() && day >= 8 && day <= 14 ) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  };

}
