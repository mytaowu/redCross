import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/login.vue'
import Home from '../components/admin/home.vue'
import DonationGood from '../components/admin/donationGood.vue'
import DonationGoodInfo from '../components/admin/donationGoodInfo.vue'
import DonationMoney from '../components/admin/donationMoney.vue'
import ReceivingMoneyDonation from '../components/admin/receivingMoneyDonation.vue'
import ReceivingGoodDonation from '../components/admin/receivingGoodDonation.vue'
import UserInfoManager from '../components/admin/userInfoManager.vue'
import UserInfoProhibitManager from '../components/admin/userInfoProhibitManager.vue'
import AdminMain from '../components/admin/main.vue'
import NormalHome from '../components/admin/normalHome.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/admin',
    name: 'Home',
    component: Home,
    children:[
      {
        path: '/',
        name: 'adminMain',
        component: AdminMain,
      },
      {
        path: '/admin/donation/good',
        name: 'donationGood',
        component: DonationGood,
      },
      {
        path: '/admin/donation/good/info',
        name: 'donationGoodInfo',
        component: DonationGoodInfo,
      },
      {
        path: '/admin/donation/money',
        name: 'donationMoney',
        component: DonationMoney,
      },
      {
        path: '/admin/receiving/good/donation',
        name: 'receivingGoodDonation',
        component: ReceivingGoodDonation,
      },
      {
        path: '/admin/receiving/money/donation',
        name: 'receivingMoneyDonation',
        component: ReceivingMoneyDonation,
      },
      {
        path: '/admin/user/maneger',
        name: 'userInfoManager',
        component: UserInfoManager,
      },
      {
        path: '/admin/user/prohibit/maneger',
        name: 'userInfoProhibitManager',
        component: UserInfoProhibitManager,
      }
    ]
  },
  {
    path: '/normal/admin',
    name: 'normalHome',
    component: NormalHome,
  }
]

const router = new VueRouter({
  routes
})

export default router
