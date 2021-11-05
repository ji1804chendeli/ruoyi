import request from '@/utils/request'

// 查询人员休息记录列表
export function listUserScheduler(query) {
  return request({
    url: '/system/userScheduler/list',
    method: 'get',
    params: query
  })
}

// 查询人员休息记录详细
export function getUserScheduler(userschedulerid) {
  return request({
    url: '/system/userScheduler/' + userschedulerid,
    method: 'get'
  })
}

// 新增人员休息记录
export function addUserScheduler(data) {
  return request({
    url: '/system/userScheduler',
    method: 'post',
    data: data
  })
}

// 修改人员休息记录
export function updateUserScheduler(data) {
  return request({
    url: '/system/userScheduler',
    method: 'put',
    data: data
  })
}

// 删除人员休息记录
export function delUserScheduler(userschedulerid) {
  return request({
    url: '/system/userScheduler/' + userschedulerid,
    method: 'delete'
  })
}

// 导出人员休息记录
export function exportUserScheduler(query) {
  return request({
    url: '/system/userScheduler/export',
    method: 'get',
    params: query
  })
}