<template>
	<view class="px-2 py-2">
		<!-- 未登录 -->
		<template v-if="!loginStatus">
			<view class="flex align-cente p-2" hover-class="bg-light">
				<image src="../../static/img/nologin.jpeg" class="size-100 rounded-circle"></image>
				<text @tap="open('login')" class="flex flex-1 justify-center mt-3">登录，体验更多功能！</text>
				<text class="iconfont icon-jinru mt-3"></text>
			</view>
			<view class="px-3 py-2">
				<image src="../../static/img/banner.png" mode="widthFix" class="w-100 rounded"></image>
			</view>
		</template>
		<!-- 登录 -->
		<template v-else>
				<!-- 头像区域 -->
				<view class="flex align-center p-2 py-3 bg-white mt-2">	
					<image :src="avatar" class="size-100 rounded-circle"></image>
					<view class="flex-1 flex flex-column px-3">
						<text class="font-md font-weight-bold text-body mb-1">{{user.nickname}}</text>
						<view>
							<text class="mr-1 text-muted">总帖数</text>
							<text class="text-warning">{{data[0].num}}</text>
							<text class="mx-1 text-muted">今日发帖</text>
							<text class="text-warning">{{data[1].num}}</text>	
						</view>
					</view>
					<text class="iconfont icon-jinru" @tap="open('settings')"></text>
				</view>
				
				<!-- 数据区域 -->
				<view class="flex align-center bg-white py-3 my-2">
					<view v-for="(item,index) in data" :key="index"
						class="flex flex-column flex-1 align-center justify-center">
						<text class="mb-1 font-md text-body font-weight-bold text-pink">{{item.num}}</text>
						<text class="font-sm text-muted">{{item.title}}</text>
						
					</view>
				</view>
				
				<!-- banner区域 -->
				<view class="p-2">
					<image src="../../static/img/banner.png" mode="widthFix" class="w-100 rounded"></image>
				</view>
				
				<!-- 列表区域 -->
				<view class="pt-2 bg-white mt-1">
					<view class="border-bottom">
						<uni-list-item showExtraIcon title="浏览历史">
							<text slot="icon" class="iconfont icon-liulan text-body font-md">
							</text>
						</uni-list-item>
					</view>
					<view class="border-bottom">
						<uni-list-item showExtraIcon title="会员VIP">
							<text slot="icon" class="iconfont icon-huiyuanvip text-body font-md">
							</text>
						</uni-list-item>
					</view>
					<view class="border-bottom">
						<uni-list-item showExtraIcon title="审核帖子">
							<text slot="icon" class="iconfont icon-keyboard text-body font-md">
							</text>
						</uni-list-item>
					</view>		
				</view>
		</template>
	</view>
</template>

<script>
	import uniListItem from '@/components/uni/uni-list-item/uni-list-item.vue'
	export default {
		components:{
			uniListItem
		},
		data() {
			return {
				loginStatus: false,
				user: {},
				data: [{
					title: '帖子',
					num: 666,
				},
				{
					title: '动态',
					num: 66,
				},
				{
					title: '评论',
					num: 7777,
				},
				{
					title: '粉丝',
					num: 1000000,
				},
				]
			}
		},
		onShow() {
			//从本地缓存读取user，如果为空，loginStatus为false，否则为true，将其信息渲染在页面
			this.user = uni.getStorageSync('user')
			if(Object.keys(this.user).length === 0) {
				this.loginStatus = false
			}else {
				this.loginStatus = true
			}
			console.log(this.user)
			console.log(this.loginStatus)
		},
		computed: {
			avatar() {
				return this.user.avatar;
			}
		},
		onNavigationBarButtonTap() {
			
			uni.showToast({
				title: '你好！' + this.user.nickname,
				duration: 2000
			})
		},
		methods: {
			open(path) {
				uni.navigateTo({
					url: `../${path}/${path}`,
				})
			},
		}
	}
</script>

<style>

</style>
