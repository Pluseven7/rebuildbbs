//package com.rebuild.service.impl;
//
//import com.rebuild.mapper.SysBoardMapper;
//import com.rebuild.mapper.SysLabelMapper;
//import com.rebuild.mapper.SysModifyMapper;
//import com.rebuild.model.SysBoard;
//import com.rebuild.model.SysLabel;
//import com.rebuild.model.SysModify;
//import com.rebuild.model.SysTopic;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class Auto<T> extends SysModifyServiceImpl{
//
//    @Resource
//    private SysModifyMapper sysModifyMapper;
//
//    @Resource
//    private SysBoardMapper sysBoardMapper;
//
//    @Resource
//    private SysLabelMapper sysLabelMapper;
//
//    protected T model;
//
//    //        private T createModel() {
////            try {
////                Type superClass = getClass().getGenericSuperclass();
////                Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
////                Class<?> clazz = getRawType(type);
////                return (T) clazz.newInstance();
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////            return null;
////        }
//    //        private SysModify autoUpdate(SysLabel model){
////            SysModify sysModify = baseMapper.selectById(model.getLbModifyId());
////            sysModify.setMfLasteventId(model.getLbAdminId());
////            sysModify.setMfLastevent(getNow());
////            baseMapper.updateById(sysModify);
////            return baseMapper.selectOne(new QueryWrapper<>(sysModify));
////        }
//    public List<SysModify> auto(T model) {
//        this.model = model;
//        SysModify sysModify;
//        List ls = new ArrayList();
////            this.getId(model);
//        if (model instanceof SysLabel){
//            sysModify = autoUpdate(((SysLabel) model).getLbModifyId(),((SysLabel) model).getLbAdminId());
//            ls.add(sysModify);
//            return ls;
//        }
//        if (model instanceof SysBoard){
//            Integer mfId = sysLabelMapper.selectById(((SysBoard) model).getBdLbId()).getLbModifyId();
//            Integer leId = ((SysBoard) model).getBdAdminId();
//            sysModify = autoUpdate(mfId, leId);
//            baseMapper.updateById(sysModify);
//            ls.add(sysModify);
//
//            sysModify = baseMapper.selectById(((SysBoard) model).getBdModifyId());
//            autoUpdate(sysModify.getMfId(),leId);
//            baseMapper.updateById(sysModify);
//            ls.add(sysModify);
//
//            return ls;
//        }
//        if (model instanceof SysTopic){
//            Integer leId = ((SysTopic) model).getTpManagerId();
//
//            SysLabel sysLabel = sysLabelMapper.selectById(((SysTopic) model).getTpBdId());
//            sysModify = autoUpdate(sysLabel.getLbModifyId(), leId);
//            ls.add(sysModify);
//            baseMapper.updateById(sysModify);
//
//            sysModify = baseMapper.selectById(sysBoardMapper.selectById(((SysTopic) model).getTpBdId()).getBdModifyId());
//            sysModify = autoUpdate(sysModify.getMfId(),leId);
//            autoUpdate(sysModify.getMfId(),leId);
//            ls.add(sysModify);
//            baseMapper.updateById(sysModify);
//
//            sysModify = baseMapper.selectById(((SysTopic) model).getTpModifyId());
//            sysModify = autoUpdate(sysModify.getMfId(),leId);
//            ls.add(sysModify);
//            baseMapper.updateById(sysModify);
//
//            return ls;
//        }
//        return null;
//    }
//
////
////        public Map<String, Integer> getId(T t){
////            try{
////                Class<? extends Object> tClass = t.getClass();
////                Map<String, Integer> map = new HashMap<>();
////                //??????????????????
////                Field[] field = tClass.getDeclaredFields();
////
////                /**
////                 * for???????????????????????????
////                 */
////                //??????????????????????????????
////                for (int i = 0;i<field.length;i++) {
////                    field[i].setAccessible(true);
////
////                    //?????????????????????
////                    String name = field[0].getName();
////                    //?????????????????????????????????
////                    name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
////
////
////                    // ??????????????????
////                    String type = field[i].getGenericType().toString();
////
////                    if(type.equals("class java.lang.Integer")){
////                        //????????? getId() ??????????????????
////                        Method m = tClass.getMethod("get"+name);
////                        //???????????????????????????get???????????????????????????????????????
////                        Integer value = (Integer)m.invoke(t);
////                        map.put(type,value);
////                    }
////                    return map;
////                }
////                //???????????? T ?????????????????????????????????id;
////            }catch(Exception e){
////                log.error("??????????????????");
////                return null;
////            }
////            return null;
////        }
//
//}/*
//    // type????????????????????????????????????type??????class?????????????????????????????????
//    private static Class<?> getRawType(Type type) {
//        if (type instanceof Class) {
//            return (Class) type;
//        } else if (type instanceof ParameterizedType) {
//            ParameterizedType parameterizedType = (ParameterizedType) type;
//            Type rawType = parameterizedType.getRawType();
//            return (Class) rawType;
//        } else if (type instanceof GenericArrayType) {
//            Type componentType = ((GenericArrayType) type).getGenericComponentType();
//            return Array.newInstance(getRawType(componentType), 0).getClass();
//        } else if (type instanceof TypeVariable) {
//            return Object.class;
//        } else if (type instanceof WildcardType) {
//            return getRawType(((WildcardType) type).getUpperBounds()[0]);
//        } else {
//            String className = type == null ? "null" : type.getClass().getName();
//            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
//        }
//    }*/
//
//
