package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new me.akshay.arclothing.DataBinderMapperImpl());
  }
}
