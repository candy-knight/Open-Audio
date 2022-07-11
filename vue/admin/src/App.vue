<template>
  <div>
<!--头部-->
    <Header />
<!--侧边栏-->
    <div style="display: flex">
      <Aside/>
<!--内容区域-->
      <router-view style="flex: 1"/>
    </div>
  </div>
  <router-view/>
</template>

<style lang="less">
@import url("//unpkg.com/element-ui@2.15.6/lib/theme-chalk/index.css");
</style>

<script>
import Header from '@/components/Header';
import Aside from "@/components/Aside";

export default {
  name: "Layout",
  components:{
    Header,Aside
  }
}
</script>