页面跳转:
1. ARouter.getInstance().build(RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY).greenChannel().navigation(getActivity(), new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    //找到页面
                }

                @Override
                public void onLost(Postcard postcard) {
                    //找不到页面
                }

                @Override
                public void onArrival(Postcard postcard) {
                    //打开页面
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    //被拦截器拦截
                }
            });
2. 如果不想走拦截器: ARouter.getInstance().build(RouterConfig.GOODS_GOODS_DETAIL_ACTIVITY).greenChannel().navigation();

3. 获取fragment: (Fragment) ARouter.getInstance().build("/home/homefragment").navigation()


偏好设置: SPUtil.java
Toast: ToastUtil.java

设置ToolBar:
    只设置标题: 继承BaseActivity或者SwipeActivity  ,调用 setTitle("我是标题")方法设置;
    设置多个属性: titleBar.setCenterText("发布采购")

                            .setLeftIcon(R.drawable.nav_back)
                            .setLeftIconOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.i(TAG, "onClick: 左边图标");
                                }
                            })
                            .setLeftText("取消")
                            .setLeftTextPaddingLeft(4)
                            .setLeftTextOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i(TAG, "onClick: 左边文字");
                                }
                            })
                            .setRightIcon(R.drawable.nav_back)
                            .setRightIconOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.i(TAG, "onClick: 右侧图标");
                                }
                            })
                            .setRightText("保存")
                            .setRightTextPaddingRight(4)
                            .setRightTextOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.i(TAG, "onClick: 右边文字");
                                }
                            })
                    ;