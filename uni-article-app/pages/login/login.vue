<template>
	<view>
		<!-- #ifndef MP-WEIXIN -->
		<uni-status-bar></uni-status-bar>
		<view @tap="back()" class="iconfont icon-guanbi flex align-center justify-center font-lg size-100">
		</view>
		<!-- #endif -->
		<template v-if="choice">
			<view class="">
				<view class="text-center py-5">
					<text class="h3 text-body">账号密码登录</text>
				</view>
				<view class="flex mb-2 px-2">
					<input type="text" v-model="phone" placeholder="请输入手机号" class="border-bottom p-2 flex-1">
				</view>
				<view class="flex mb-2 px-2">
					<input type="password" v-model="password" placeholder="请输入密码" class="border-bottom p-2 flex-1">
					<text class="flex align-center font-sm text-muted p-3">忘记密码?</text>
				</view>
				<view class="p-2">
					<button class="rounded-circle bg-pink text-white" :disabled="!canSubmit" @tap="login">登录</button>
				</view>
			</view>
			<view class="flex flex-1"></view>
			
			<view class="text-center p-2 text-primary font-sm">
				<text @tap="loginChoice">验证码登录</text>
				<text class="mx-2"> | </text>
				<text>登录遇到问题</text>
			</view>
			
		</template>
		
		<template v-else>
			<view class="">
				<view class="text-center py-5">
					<text class="h3 text-body">验证码登录</text>
				</view>
				<view class="flex mb-2 px-2">
					<view class="border-right font px-2 flex align-center">+86</view>
					<input type="text" v-model="phone" placeholder="请输入手机号" class="border-bottom p-2 flex-1">
				</view>
				<view class="flex mb-2 px-2" v-if="canGetCode">
					<input type="text" v-model="verifyCode" placeholder="请输入验证码" class="border-bottom p-2 flex-1">
					<view @tap="getCode"
					class="font-sm px-3 flex align-center rounded text-white bg-pink">
						点击获取验证码
					</view>
				</view>
				<view class="flex mb-2 px-2" v-else>
					<input type="text" v-model="verifyCode" placeholder="请输入验证码" class="border-bottom p-2 flex-1">
					<view
					class="font-sm px-3 flex align-center rounded text-white bg-pink-disabled">
						{{limitTime}}秒后可再次获取验证码
					</view>
				</view>
				
				<view class="p-2">
					<button class="rounded-circle bg-pink text-white" :disabled="!canSubmit">登录</button>
				</view>
			</view>
			
			<view class="text-center p-2 text-primary font-sm">
				<text @tap="loginChoice">验证码登录</text>
				<text class="mx-2"> | </text>
				<text>登录遇到问题</text>
			</view>
			
		</template>
		<template>
			<view class="footer">
				<text class="flex align-center justify-center ">免注册登录</text>
				<view class="flex align-center px-2 pt-3">
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="iconfont icon-QQ h2 text-blue-qq"></text>
						<text class="font-sm text-muted">QQ登录</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="iconfont icon-weixin h2 text-green-wechat"></text>
						<text class="font-sm text-muted">微信登录</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="iconfont icon-xinlangweibo h2 text-red-weibo"></text>
						<text class="font-sm text-muted">微博登录</text>
					</view>
					<view class="flex-column flex flex-1 align-center justify-center">
						<text class="iconfont icon-gengduo1 h2"></text>
						<text class="font-sm text-muted">更多方式登录</text>
					</view>
				</view>
				<view class="flex font-italic justify-center text-muted font-sm p-3" >
					注册代表同意
					<text class="text-primary ml-1">《xxx协议》</text>
				</view>
			</view>
		</template>
	</view>
</template>

<script>
	import uniStatusBar from '@/components/uni/uni-status-bar/uni-status-bar.vue'
	export default {
		components:{
			uniStatusBar
		},
		data() {
			return {
				choice: true,
				phone: '17000000000',
				password: '',
				verifyCode: '',
				canSubmit: false,
				limitTime: 0,
				canGetCode: true
				
			}
		},
		watch: {
			verifyCode: {
				handler(newValue, oldValue) {
					if(newValue!==""){
						this.canSubmit = true
					}else{
						this.canSubmit = false
					}
				}
				
			},
			password: {
				handler(newValue, oldValue) {
					if(newValue!==""){
						this.canSubmit = true
					}else{
						this.canSubmit = false
					}
				}
				
			}
		},
		methods: {
			back() {
				// uni.showToast({
				// 	title: '返回',
				// 	duration: 2000
				// })
				uni.navigateBack({
					delta: 1
				})
			},
			loginChoice(){
				this.choice = !this.choice,
				this.password="",
				this.verifyCode=""
			},
			validate() {
			  //手机号正则
			  var mPattern = /^1[34578]\d{9}$/;
			  if (!mPattern.test(this.phone)) {
				uni.showToast({
				  title: '手机号格式不正确',
				  icon: 'none'
				});
				return false;
			  }
			  // ...更多验证
			  return true;
			},
			login() {
				//账号密码登录
				// let data = {
				// 	phone: this.phone,
				// 	password: this.password
				// }
				// const url = "";
				// uni.request({
				// 	url:url,
				// 	method: 'POST',
				// 	data: data
				// }).then((res)=>{
				// 	console.log(res)
				// })
			},
			getCode() {
				this.canGetCode = !this.canGetCode
				// 防止重复获取
				if( this.limitTime > 0){
					return ;
				}
				
				//验证手机号--没通过
				if(!this.validate()){
					return ;
				}
				this.limitTime = 5;
				let timer = setInterval(()=>{
					if(this.limitTime >=1 ){
						this.limitTime--;
					}else{
						this.limitTime = 0;
						this.canGetCode = !this.canGetCode
						clearInterval(timer);
					}
				},1000)
				
			}
		}
	}
</script>

<style>

</style>
