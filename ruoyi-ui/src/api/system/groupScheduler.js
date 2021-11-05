import request from '@/utils/request'

// 查询部门排班记录列表
export function listGroupScheduler(query) {
  return request({
    url: '/system/groupScheduler/list',
    method: 'get',
    params: query
  })
}

// 查询部门排班记录详细
export function getGroupScheduler(groupschedulerid) {
  return request({
    url: '/system/groupScheduler/' + groupschedulerid,
    method: 'get'
  })
}

// 新增部门排班记录
export function addGroupScheduler(data) {
  return request({
    url: '/system/groupScheduler',
    method: 'post',
    data: data
  })
}

// 修改部门排班记录
export function updateGroupScheduler(data) {
  return request({
    url: '/system/groupScheduler',
    method: 'put',
    data: data
  })
}

// 删除部门排班记录
export function delGroupScheduler(groupschedulerid) {
  return request({
    url: '/system/groupScheduler/' + groupschedulerid,
    method: 'delete'
  })
}

// 导出部门排班记录
export function exportGroupScheduler(query) {
  return request({
    url: '/system/groupScheduler/export',
    method: 'get',
    params: query
  })
}