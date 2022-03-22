<template>
	<view>
		<!-- 未登录 -->
		<template v-if="!isLogin">
			<view class="flex align-center">
				<image :src="avatar" class="size-100 rounded-circle"></image>
				<text @tap="goLogining">去登陆</text>
			</view>
			
		</template>
		<!-- 登录 -->
		<template v-else>
				<!-- 头像区域 -->
				<view class="flex align-center p-2">	
					<image :src="avatar" class="size-100 rounded-circle"></image>
					<view class="flex-1 flex flex-column px-3">
						<text class="font-md font-weight-bold text-muted">{{nickName}}</text>
						<view>
							<text class="mr-2">总帖子</text>
							<text class="text-warning">{{posts}}</text>
							<text class="mx-2">今日发帖</text>
							<text class="text-warning">{{dynamics}}</text>	
						</view>
					</view>
					<text class="iconfont icon-jinru" @tap="open('settings')"></text>
				</view>
				
				<!-- 数据区域 -->
				<view class="flex align-center px-2 pt-3">
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="text-pink">{{posts}}</text>
						<text class="font-sm text-muted">帖子</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="text-pink">{{posts}}</text>
						<text class="font-sm text-muted">动态</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="text-pink">{{comments}}</text>
						<text class="font-sm text-muted">评论</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="text-pink">{{fans}}</text>
						<text class="font-sm text-muted">粉丝</text>
					</view>
				</view>
				
				<!-- banner区域 -->
				<view class="p-2">
					<image src="/static/img/banner.png" mode="widthFix" class="w-100 rounded"></image>
				</view>
				
				<!-- 列表区域 -->
				<uni-list-item showExtraIcon title="浏览历史">
					<text slot="icon" class="iconfont icon-liulan text-body font-md">
					</text>
				</uni-list-item>
				<uni-list-item showExtraIcon title="会员VIP">
					<text slot="icon" class="iconfont icon-huiyuanvip text-body font-md">
					</text>
				</uni-list-item>
				<uni-list-item showExtraIcon title="审核帖子">
					<text slot="icon" class="iconfont icon-keyboard text-body font-md">
					</text>
				</uni-list-item>
				<uni-list-item showExtraIcon title="退出登录" @tap="cancleLogin">
					<text slot="icon" class="iconfont icon-guanbi1 text-body font-md">
					</text>
				</uni-list-item>
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
				isLogin: true,
				nickName: '派大星',
				posts: 666,
				dynamics: 66,
				comments: 88,
				fans: 777
			}
		},
		computed: {
			avatar() {
				return this.isLogin === true?'/static/img/my.png':'/static/img/nologin.jpeg';
			}
		},
		onNavigationBarButtonTap() {
			uni.
			uni.showToast({
				title: '你好！' + this.nickName,
				duration: 2000
			})
		},
		methods: {
			goLogining() {
				uni.navigateTo({
					url: "../login/login"
				})
			},
			cancleLogin(){
				this.isLogin = !this.isLogin
			},
			open(path) {
				uni.navigateTo({
					url: `../${path}/${path}`
				})
			}
		}
	}
</script>

<style>

</style>
